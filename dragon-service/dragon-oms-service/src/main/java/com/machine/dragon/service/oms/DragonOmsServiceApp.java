package com.machine.dragon.service.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonOmsServiceApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonOmsServiceApp.class, args);
	}
}

