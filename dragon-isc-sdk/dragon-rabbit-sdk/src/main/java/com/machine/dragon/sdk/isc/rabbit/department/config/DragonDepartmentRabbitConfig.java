package com.machine.dragon.sdk.isc.rabbit.department.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DragonDepartmentRabbitConfig {

    public static final String DRAGON_DEPARTMENT_PREFIX = "dragon.system.department.";

    public static final String DRAGON_DEPARTMENT_QUEUE = DRAGON_DEPARTMENT_PREFIX + "queue";

    public static final String DRAGON_DEPARTMENT_ROUTINE_KEY = DRAGON_DEPARTMENT_PREFIX + "routingKey";

    @Bean
    public Queue dragonDepartmentQueue() {
        return new Queue(DRAGON_DEPARTMENT_QUEUE);
    }

    @Bean
    public Binding bindingLogLoginQueueWithDirectExchange(DirectExchange directExchange) {
        return BindingBuilder.bind(dragonDepartmentQueue())
                .to(directExchange)
                .with(DRAGON_DEPARTMENT_ROUTINE_KEY);
    }
}
