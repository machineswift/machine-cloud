package com.machine.dragon.starter.redis.config;

import com.machine.dragon.common.launch.property.DragonPropertySource;
import org.springframework.context.annotation.Configuration;

@Configuration
@DragonPropertySource(value = "classpath:/dragon-redis.yml")
public class DragonRedisAutoConfiguration {

}

