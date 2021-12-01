package com.machine.dragon.server.ops.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonSwaggerServerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonSwaggerServerApp.class, args);
	}
}
