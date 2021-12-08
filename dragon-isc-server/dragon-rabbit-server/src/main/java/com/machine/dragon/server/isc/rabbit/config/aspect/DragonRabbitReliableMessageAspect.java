package com.machine.dragon.server.isc.rabbit.config.aspect;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.common.tool.string.DragonStringUtil;
import com.machine.dragon.common.core.bean.rabbit.DragonRabbitBaseMessage;
import com.machine.dragon.service.system.rabbit.feign.DragonRabbitReliableMessageClient;
import com.machine.dragon.service.system.rabbit.feign.invo.DragonRabbitReliableMessageInitInVO;
import com.machine.dragon.service.system.rabbit.feign.invo.DragonRabbitReliableMessageUpdate4SubscribeInVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Slf4j
@Aspect
@Component
public class DragonRabbitReliableMessageAspect {

    @Autowired
    private DragonRabbitReliableMessageClient dragonRabbitReliableMessageClient;

    /**
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.machine.dragon.server.isc.rabbit.config.aspect.DragonRabbitReliableMessageAnnotation)")
    public void producer() {
    }

    /**
     * 环绕通知
     */
    @Around(value = "producer()&&@annotation(reliableMessageAnnotation)&&@annotation(rabbitListener)")
    public Object Around(ProceedingJoinPoint pjp,
                         DragonRabbitReliableMessageAnnotation reliableMessageAnnotation,
                         RabbitListener rabbitListener) throws Throwable {
        DragonRabbitBaseMessage message = (DragonRabbitBaseMessage) pjp.getArgs()[0];
        DragonRabbitReliableMessage reliableMessage = message.getReliableMessage();

        //todo 多租户处理
        //MultiTenantContent.setTenantId(message.getTenantId());

        if (null != reliableMessage.getId()) {
            //重试消息广播场景：非自己消费的消息异常则跳过,防止重复处理
            if (!DragonJsonUtil.toJson(rabbitListener.queues()).equals(reliableMessage.getSubscribeQueues())) {
                log.warn("消费消息忽略非自己消费的可靠消息 {} queues:{} message:{}", reliableMessageAnnotation.publishName(),
                        DragonJsonUtil.toJson(rabbitListener.queues()), DragonJsonUtil.toJson(message));
                return null;
            }
        }

        log.info("消费消息 {} queues:{} message:{}", reliableMessageAnnotation.publishName(),
                DragonJsonUtil.toJson(rabbitListener.queues()), DragonJsonUtil.toJson(message));

        return pjp.proceed();
    }

    /**
     * 后置通知(方法返回)
     */
    @AfterReturning(value = "producer()&&@annotation(reliableMessageAnnotation)&&@annotation(rabbitListener)")
    public void afterReturning(JoinPoint jp,
                               DragonRabbitReliableMessageAnnotation reliableMessageAnnotation,
                               RabbitListener rabbitListener) {
        DragonRabbitBaseMessage message = (DragonRabbitBaseMessage) jp.getArgs()[0];
        DragonRabbitReliableMessage reliableMessage = message.getReliableMessage();

        if (null != reliableMessage.getId()) {
            //重试消息广播场景：非自己消费的消息异常则跳过,防止可靠消息被删除
            if (!DragonJsonUtil.toJson(rabbitListener.queues()).equals(reliableMessage.getSubscribeQueues())) {
                return;
            }
            dragonRabbitReliableMessageClient.deleteById(message.getReliableMessage().getId());
        }
        //todo 多租户处理
        //MultiTenantContent.clearTenantId();
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "producer()&&@annotation(reliableMessageAnnotation)&&@annotation(rabbitListener)", throwing = "exception")
    public void afterThrowing(JoinPoint jp,
                              DragonRabbitReliableMessageAnnotation reliableMessageAnnotation,
                              RabbitListener rabbitListener,
                              Exception exception) {
        DragonRabbitBaseMessage rabbitBaseMessage = (DragonRabbitBaseMessage) jp.getArgs()[0];
        log.error(String.format("消费消息异常,%s queues:%s message:%s", reliableMessageAnnotation.publishName(),
                DragonJsonUtil.toJson(rabbitListener.queues()), DragonJsonUtil.toJson(rabbitBaseMessage)), exception);

        //补偿逻辑处理
        int[] retryStrategy = reliableMessageAnnotation.retryStrategy();
        if (retryStrategy.length == 0) {
            return;
        }

        DragonRabbitReliableMessage reliableMessage = rabbitBaseMessage.getReliableMessage();
        if (null == reliableMessage.getId()) {
            //第一次重试,添加消费者以及补偿策略信息
            reliableMessage.setTenantId(rabbitBaseMessage.getTenantId());
            reliableMessage.setSubscribeName(reliableMessageAnnotation.publishName());
            reliableMessage.setSubscribeQueues(DragonJsonUtil.toJson(rabbitListener.queues()));
            reliableMessage.setResendTimes(0);
            reliableMessage.setMaxResendTimes(reliableMessageAnnotation.maxResendTimes());
            reliableMessage.setRetryStrategy(DragonJsonUtil.toJson(reliableMessageAnnotation.retryStrategy()));

            //生产消息唯一键
            reliableMessage.setMessageKey(generateMessageKey(rabbitBaseMessage, reliableMessageAnnotation));

            //添加消息内容
            reliableMessage.setMessageContent(DragonJsonUtil.toJson(rabbitBaseMessage));
            rabbitBaseMessage.setReliableMessage(reliableMessage);
            String id = dragonRabbitReliableMessageClient.init(DragonJsonUtil.copy(reliableMessage, DragonRabbitReliableMessageInitInVO.class));
            reliableMessage.setId(id);
        } else {
            //重试消息广播场景：非自己消费的消息则跳过,防止消息数量膨胀
            if (!DragonJsonUtil.toJson(rabbitListener.queues()).equals(reliableMessage.getSubscribeQueues())) {
                return;
            }

            //重新查询,防止消息消息延迟引起的重试策略错乱
            reliableMessage = dragonRabbitReliableMessageClient.getById(reliableMessage.getId());
            if (null == reliableMessage) {
                //已经被正确处理或已经被移到dead里面
                return;
            }
            rabbitBaseMessage.setReliableMessage(reliableMessage);
        }

        rabbitBaseMessage.setException(exception);
        processReliableMessage(reliableMessageAnnotation.retryStrategy(), reliableMessage);

        //todo 多租户处理
        //清理租户信息
        //MultiTenantContent.clearTenantId();
    }

    /**
     * 规则:MD5(tenantId+publishExchange+publishRoutingKey+subscribeQueues)+value(uniqueKeyFields)
     */
    private String generateMessageKey(DragonRabbitBaseMessage rabbitBaseMessage,
                                      DragonRabbitReliableMessageAnnotation reliableMessageAnnotation) {
        DragonRabbitReliableMessage reliableMessage = rabbitBaseMessage.getReliableMessage();
        StringBuilder md5Sb = new StringBuilder();
        md5Sb.append(reliableMessage.getPublishExchange()).append("-");
        md5Sb.append(reliableMessage.getPublishRoutingKey()).append("-");
        md5Sb.append(reliableMessage.getSubscribeQueues());

        //解析唯一键的值
        StringBuilder valuesSb = new StringBuilder();
        String[] uniqueKeyFields = reliableMessageAnnotation.uniqueKeyFields();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(DragonJsonUtil.toJson(rabbitBaseMessage));
        for (String field : uniqueKeyFields) {
            String value = JsonPath.read(document, field).toString();
            if (DragonStringUtil.isNotEmpty(value)) {
                valuesSb.append(value).append("-");
            }
        }
        if (valuesSb.length() > 0) {
            valuesSb.deleteCharAt(valuesSb.length() - 1);
        }

        return DigestUtils.md5DigestAsHex(md5Sb.toString().getBytes()).
                replaceAll("-", "") + ":" + valuesSb.toString();
    }

    public void processReliableMessage(int[] retryStrategy,
                                       DragonRabbitReliableMessage reliableMessage) {
        Integer resendTimes = reliableMessage.getResendTimes();
        if (resendTimes > (retryStrategy.length) - 1) {
            //将消息移到死亡消息表
            dragonRabbitReliableMessageClient.deadById(reliableMessage.getId());
        } else {
            //修改可靠消息消费状态
            DragonRabbitReliableMessageUpdate4SubscribeInVO inVo = new DragonRabbitReliableMessageUpdate4SubscribeInVO();
            inVo.setId(reliableMessage.getId());
            inVo.setNextTimeSeconds(retryStrategy[resendTimes]);
            inVo.setReason(reliableMessage.getReason());
            inVo.setRemark(reliableMessage.getRemark());
            dragonRabbitReliableMessageClient.update4Subscribe(inVo);
        }
    }
}
