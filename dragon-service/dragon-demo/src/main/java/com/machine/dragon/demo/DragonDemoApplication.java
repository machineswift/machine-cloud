package com.machine.dragon.demo;

import com.machine.dragon.common.cloud.feign.EnableDragonFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDragonFeignClients
public class DragonDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DragonDemoApplication.class, args);
    }
}

