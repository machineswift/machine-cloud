package com.machine.dragon.starter.mybatis.config;

import com.machine.dragon.common.launch.property.DragonPropertySource;
import com.machine.dragon.starter.mybatis.property.DragonMybatisPlusProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({DragonMybatisPlusProperties.class})
@DragonPropertySource(value = "classpath:/dragon-mybatis.yml")
public class DragonMybatisPlusAutoConfiguration  {

}

