package com.machine.dragon.server.isc.rabbit.config.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DragonRabbitReliableMessageAnnotation {
    /**
     * 生产者名称
     */
    String publishName() default "";

    /**
     * 重试策略
     */
    int[] retryStrategy() default {};

    /**
     * 唯一键字段
     */
    String[] uniqueKeyFields() default {};

    /**
     * 最大重发次数(防止队列阻塞触发无限循环发送可靠消息)
     */
    int maxResendTimes() default 12;
}
