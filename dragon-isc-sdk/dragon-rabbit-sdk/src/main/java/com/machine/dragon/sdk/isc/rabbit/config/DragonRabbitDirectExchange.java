package com.machine.dragon.sdk.isc.rabbit.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DragonRabbitDirectExchange {

    public static final String DRAGON_DIRECT_EXCHANGE = "dragon.direct.exchange";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DRAGON_DIRECT_EXCHANGE);
    }
}
