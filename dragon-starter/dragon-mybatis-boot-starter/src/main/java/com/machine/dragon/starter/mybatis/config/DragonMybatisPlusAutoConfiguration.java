package com.machine.dragon.starter.mybatis.config;

import com.machine.dragon.common.launch.property.DragonPropertySource;
import com.machine.dragon.starter.mybatis.property.DragonMybatisPlusProperties;
import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@MapperScan("com.machine.dragon.service.**.mapper.**")
@EnableConfigurationProperties(DragonMybatisPlusProperties.class)
@DragonPropertySource(value = "classpath:/dragon-mybatis.yml")
public class DragonMybatisPlusAutoConfiguration {

}

