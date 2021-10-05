package com.training.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class SampleRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRestApplication.class, args);
	}

}
