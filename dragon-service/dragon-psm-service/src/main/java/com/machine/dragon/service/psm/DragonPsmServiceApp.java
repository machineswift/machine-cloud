package com.machine.dragon.service.psm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonPsmServiceApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonPsmServiceApp.class, args);
	}
}

