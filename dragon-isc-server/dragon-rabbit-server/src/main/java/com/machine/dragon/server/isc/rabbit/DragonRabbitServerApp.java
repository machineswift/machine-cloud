package com.machine.dragon.server.isc.rabbit;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {DragonAppConstant.BASE_PACKAGES})
public class DragonRabbitServerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonRabbitServerApp.class, args);
	}

}

