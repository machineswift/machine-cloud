package com.machine.dragon.service.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonCoreServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonCoreServiceApplication.class, args);
	}
}

