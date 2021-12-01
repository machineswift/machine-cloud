package com.machine.dragon.server.isc.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DragonRabbitServerConfig {

    public static final String LISTENER_4_HIGH_DELAY = "listener4HighDelay";

    public static final String LISTENER_4_MEDIUM_DELAY = "listener4MediumDelay";

    public static final String LISTENER_4_DEFAULT_SERVICE = "listener4DefaultService";

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;


    /**
     * 不能接受高并发,可接受高延迟的业务
     */
    @Bean(name = LISTENER_4_HIGH_DELAY)
    public SimpleRabbitListenerContainerFactory listener4Delay() {
        return getSimpleRabbitListenerContainerFactory(8);
    }

    /**
     * 不能接受高并发,接受部分延迟的业务
     */
    @Bean(name = LISTENER_4_MEDIUM_DELAY)
    public SimpleRabbitListenerContainerFactory listener4MediumDelay() {
        return getSimpleRabbitListenerContainerFactory(6);
    }

    /**
     * 默认业务
     */
    @Bean(name = LISTENER_4_DEFAULT_SERVICE)
    public SimpleRabbitListenerContainerFactory listener4DefaultService() {
        return getSimpleRabbitListenerContainerFactory(25);
    }

    private SimpleRabbitListenerContainerFactory getSimpleRabbitListenerContainerFactory(int maxConcurrency) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        cachingConnectionFactory.getRabbitConnectionFactory().setRequestedChannelMax(8192);
        if (maxConcurrency < 5) {
            cachingConnectionFactory.setChannelCacheSize(maxConcurrency + 5);
        } else if (maxConcurrency < 10) {
            cachingConnectionFactory.setChannelCacheSize(maxConcurrency * 2);
        } else if (maxConcurrency < 20) {
            cachingConnectionFactory.setChannelCacheSize(maxConcurrency + 12);
        } else {
            cachingConnectionFactory.setChannelCacheSize(maxConcurrency + 20);
        }
        factoryConfigurer.configure(factory, cachingConnectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(maxConcurrency);
        factory.setPrefetchCount(80);
        return factory;
    }
}
