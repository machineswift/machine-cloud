package com.machine.dragon.service.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonSystemServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DragonSystemServiceApplication.class, args);
    }
}