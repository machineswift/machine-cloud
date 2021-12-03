package com.machine.dragon.web.crm;

import com.machine.dragon.common.cloud.feign.EnableDragonFeignClients;
import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableDragonFeignClients
@SpringBootApplication(scanBasePackages = {DragonAppConstant.BASE_PACKAGES})
public class DragonWebCrmApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DragonWebCrmApp.class, args);
    }
}

