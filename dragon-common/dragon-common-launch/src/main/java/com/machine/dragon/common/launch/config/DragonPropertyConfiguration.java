package com.machine.dragon.common.launch.config;

import com.machine.dragon.common.launch.property.DragonProperties;
import com.machine.dragon.common.launch.property.DragonPropertySourcePostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration(proxyBeanMethods = false)
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(DragonProperties.class)
public class DragonPropertyConfiguration {

	@Bean
	public DragonPropertySourcePostProcessor dragonPropertySourcePostProcessor() {
		return new DragonPropertySourcePostProcessor();
	}

}
