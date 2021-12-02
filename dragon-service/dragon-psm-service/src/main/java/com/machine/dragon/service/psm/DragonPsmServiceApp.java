package com.machine.dragon.service.psm;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {DragonAppConstant.BASE_PACKAGES})
public class DragonPsmServiceApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonPsmServiceApp.class, args);
	}
}

