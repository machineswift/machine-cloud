package com.machine.dragon.server.isc.xxljob;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {DragonAppConstant.BASE_PACKAGES})
public class DragonXxlJobExecutorServerApp {

	public static void main(String[] args) {
        SpringApplication.run(DragonXxlJobExecutorServerApp.class, args);
	}

}