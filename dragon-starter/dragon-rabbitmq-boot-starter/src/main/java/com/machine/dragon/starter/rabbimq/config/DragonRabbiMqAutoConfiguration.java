package com.machine.dragon.starter.rabbimq.config;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties
public class DragonRabbiMqAutoConfiguration {

    private final CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        cachingConnectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        cachingConnectionFactory.setPublisherReturns(true);
        cachingConnectionFactory.getRabbitConnectionFactory().setRequestedChannelMax(8192);
        cachingConnectionFactory.setChannelCacheSize(50);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(DragonJsonUtil.getInstance()));
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
        });
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
        });
        return rabbitTemplate;
    }
}

