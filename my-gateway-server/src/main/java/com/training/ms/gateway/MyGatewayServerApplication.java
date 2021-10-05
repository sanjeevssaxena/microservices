package com.training.ms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyGatewayServerApplication.class, args);
	}

}
