package com.machine.dragon.service.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonSystemServiceApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DragonSystemServiceApp.class, args);
    }
}