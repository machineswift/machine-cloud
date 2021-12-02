package com.machine.dragon.service.crm;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {DragonAppConstant.BASE_PACKAGES})
public class DragonCrmServiceApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonCrmServiceApp.class, args);
	}
}

