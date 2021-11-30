package com.machine.dragon.server.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DragonGatewayServerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DragonGatewayServerApp.class, args);
	}
}

