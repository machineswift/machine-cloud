package com.machine.dragon.service.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonCrmServiceApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonCrmServiceApp.class, args);
	}
}

