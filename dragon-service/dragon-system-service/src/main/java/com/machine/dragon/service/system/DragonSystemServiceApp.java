package com.machine.dragon.service.system;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {DragonAppConstant.BASE_PACKAGES})
public class DragonSystemServiceApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DragonSystemServiceApp.class, args);
    }
}