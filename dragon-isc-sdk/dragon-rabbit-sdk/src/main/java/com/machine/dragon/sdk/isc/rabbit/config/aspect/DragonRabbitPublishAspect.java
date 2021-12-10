package com.machine.dragon.sdk.isc.rabbit.config.aspect;

import com.machine.dragon.common.core.bean.rabbit.DragonRabbitReliableMessage;
import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.common.core.bean.rabbit.DragonRabbitBaseMessage;
import com.machine.dragon.sdk.isc.rabbit.config.DragonRabbitCommitExecutor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Aspect
@Component
public class DragonRabbitPublishAspect {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DragonRabbitCommitExecutor dragonRabbitCommitExecutor;

    /**
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.machine.dragon.sdk.isc.rabbit.config.aspect.DragonRabbitPublishAnnotation)")
    public void producer() {
    }

    /**
     * 前置通知
     */
    @Before(value = "producer()&&@annotation(annotation)")
    public void before(JoinPoint jp,
                       DragonRabbitPublishAnnotation annotation) {
        DragonRabbitBaseMessage message = (DragonRabbitBaseMessage) jp.getArgs()[0];

        //todo 多租户处理
        //message.setTenantId(MultiTenantContent.currentTenantId());

        //添加生产者信息
        message.setReliableMessage(new DragonRabbitReliableMessage(message.getClass().getName(), annotation.producerName(),
                annotation.exchange(), annotation.routingKey()));
    }

    /**
     * 后置通知
     */
    @After(value = "producer()&&@annotation(annotation)")
    public void after(JoinPoint jp,
                      DragonRabbitPublishAnnotation annotation) {
        dragonRabbitCommitExecutor.execute(() -> {
            String routingKey = annotation.routingKey();
            if (StringUtils.isEmpty(routingKey)) {
                routingKey = null;
            }
            DragonRabbitBaseMessage rabbitBaseMessage = (DragonRabbitBaseMessage) jp.getArgs()[0];

            //todo 多租户处理
            //MultiTenantContent.setTenantId(message.getTenantId());

            log.info("生产消息 {} {} {} message:{}", annotation.producerName(), annotation.exchange(),
                    annotation.routingKey(), DragonJsonUtil.toJson(rabbitBaseMessage));
            rabbitTemplate.convertAndSend(annotation.exchange(), routingKey, rabbitBaseMessage);
        });
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "producer()&&@annotation(annotation)", throwing = "exception")
    public void afterThrowing(JoinPoint jp,
                              DragonRabbitPublishAnnotation annotation,
                              Exception exception) {
        DragonRabbitBaseMessage message = (DragonRabbitBaseMessage) jp.getArgs()[0];
        log.error(String.format("生产消息异常,%s %s %s message:%s", annotation.producerName(), annotation.exchange(),
                annotation.routingKey(), DragonJsonUtil.toJson(message)), exception);
    }
}
