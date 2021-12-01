package com.machine.dragon.server.isc.rabbit.config.aspect;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.machine.dragon.service.system.rabbit.feign.DragonRabbitReliableMessageClient;
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
    @Around(value = "producer()&&@annotation(reliableAnnotation)&&@annotation(rabbitListener)")
    public Object Around(ProceedingJoinPoint pjp,
                         MessageReliableAnnotation reliableAnnotation,
                         RabbitListener rabbitListener) throws Throwable {
        RabbitMqMessage message = (RabbitMqMessage) pjp.getArgs()[0];
        MessageReliable messageReliable = message.getMessageReliable();
        MultiTenantContent.setTenantId(message.getTenantId());
        if (null != messageReliable.getId()) {
            //重试消息广播场景：非自己消费的消息异常则跳过,防止重复处理
            if (!JsonUtils.object2JsonStr(rabbitListener.queues()).equals(messageReliable.getConsumerQueues())) {
                log.warn("消费消息忽略非自己消费的可靠消息 {} queues:{} message:{}", reliableAnnotation.consumerName(),
                        JsonUtils.object2JsonStr(rabbitListener.queues()), JsonUtils.object2JsonStr(message));
                return null;
            }
        }
        if (SY_LOG_API_QUEUE.equals(rabbitListener.queues()[0])) {
            //日志拦截忽略打印日志
        } else {
            log.info("消费消息 {} queues:{} message:{}", reliableAnnotation.consumerName(),
                    JsonUtils.object2JsonStr(rabbitListener.queues()), JsonUtils.object2JsonStr(message));
        }

        return pjp.proceed();
    }

    /**
     * 后置通知(方法返回)
     */
    @AfterReturning(value = "producer()&&@annotation(reliableAnnotation)&&@annotation(rabbitListener)")
    public void afterReturning(JoinPoint jp,
                               MessageReliableAnnotation reliableAnnotation,
                               RabbitListener rabbitListener) {
        RabbitMqMessage message = (RabbitMqMessage) jp.getArgs()[0];
        MessageReliable messageReliable = message.getMessageReliable();
        if (null != messageReliable.getId()) {
            //重试消息广播场景：非自己消费的消息异常则跳过,防止可靠消息被删除
            if (!JsonUtils.object2JsonStr(rabbitListener.queues()).equals(messageReliable.getConsumerQueues())) {
                return;
            }
            messageReliableClient.deleteById(message.getMessageReliable().getId());
        }
        //清理租户信息
        MultiTenantContent.clearTenantId();
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "producer()&&@annotation(reliableAnnotation)&&@annotation(rabbitListener)", throwing = "exception")
    public void afterThrowing(JoinPoint jp,
                              MessageReliableAnnotation reliableAnnotation,
                              RabbitListener rabbitListener,
                              Exception exception) {
        RabbitMqMessage message = (RabbitMqMessage) jp.getArgs()[0];
        log.error(String.format("消费消息异常,%s queues:%s message:%s", reliableAnnotation.consumerName(),
                JsonUtils.object2JsonStr(rabbitListener.queues()), JsonUtils.object2JsonStr(message)), exception);

        //补偿逻辑处理
        String retryStrategy = reliableAnnotation.retryStrategy();
        if (StringUtils.isEmpty(retryStrategy)) {
            return;
        }

        MessageReliable messageReliable = message.getMessageReliable();

        if (null == messageReliable.getId()) {
            //第一次重试,添加消费者以及补偿策略信息
            messageReliable.setTenantId(message.getTenantId());
            messageReliable.setConsumerName(reliableAnnotation.consumerName());
            messageReliable.setConsumerQueues(JsonUtils.object2JsonStr(rabbitListener.queues()));
            messageReliable.setRetryStrategy(reliableAnnotation.retryStrategy());
            messageReliable.setResendTimes(0);
            messageReliable.setMaxResendTimes(reliableAnnotation.maxResendTimes());

            //生产消息唯一键
            messageReliable.setMessageKey(generateMessageKey(message, reliableAnnotation));

            //添加消息内容
            message.setMessageReliable(null);
            messageReliable.setMessageContent(JsonUtils.object2JsonStr(message));
            message.setMessageReliable(messageReliable);
            Long id = messageReliableClient.init(messageReliable);
            messageReliable.setId(id);
        } else {
            //重试消息广播场景：非自己消费的消息则跳过,防止消息数量膨胀
            if (!JsonUtils.object2JsonStr(rabbitListener.queues()).equals(messageReliable.getConsumerQueues())) {
                return;
            }

            //重新查询,防止消息消息延迟引起的重试策略错乱
            messageReliable = messageReliableClient.getById(messageReliable.getId());
            if (null == messageReliable) {
                //已经被正确处理或已经被移到dead里面
                return;
            }
        }
        message.setMessageReliable(messageReliable);
        message.setException(exception);
        MessageReliableConfig.getRouter().route(message.getMessageReliable());

        //清理租户信息
        MultiTenantContent.clearTenantId();
    }

    /**
     * 规则:MD5(producerExchange+producerRoutingKey+consumerQueues)+value(uniqueKeyFields)
     */
    private String generateMessageKey(RabbitMqMessage message,
                                      MessageReliableAnnotation reliableAnnotation) {
        MessageReliable messageReliable = message.getMessageReliable();
        StringBuilder md5Sb = new StringBuilder();
        md5Sb.append(messageReliable.getProducerExchange()).append("-");
        md5Sb.append(messageReliable.getProducerRoutingKey()).append("-");
        md5Sb.append(messageReliable.getConsumerQueues());

        //解析唯一键的值
        StringBuilder valuesSb = new StringBuilder();
        String[] uniqueKeyFields = reliableAnnotation.uniqueKeyFields();
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(JsonUtils.object2JsonStr(message));
        for (String field : uniqueKeyFields) {
            String value = JsonPath.read(document, field).toString();
            if (StringUtils.isNotEmpty(value)) {
                valuesSb.append(value).append("-");
            }
        }
        if (valuesSb.length() > 0) {
            valuesSb.deleteCharAt(valuesSb.length() - 1);
        }

        return DigestUtils.md5DigestAsHex(md5Sb.toString().getBytes()).
                replaceAll("-", "") + ":" + valuesSb.toString();
    }
}
