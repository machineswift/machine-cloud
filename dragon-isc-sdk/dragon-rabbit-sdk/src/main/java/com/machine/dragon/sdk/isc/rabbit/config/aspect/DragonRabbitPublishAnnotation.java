package com.machine.dragon.sdk.isc.rabbit.config.aspect;

import com.machine.dragon.sdk.isc.rabbit.config.DragonRabbitDirectExchange;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DragonRabbitPublishAnnotation {
    /**
     * 生产者名称
     */
    String producerName() default "";

    /**
     * 交换机
     */
    String exchange() default DragonRabbitDirectExchange.DRAGON_DIRECT_EXCHANGE;

    /**
     * 路由键
     */
    String routingKey() default "";
}
