package com.training.ms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

import com.training.ms.gateway.filter.ErrorFilter;
import com.training.ms.gateway.filter.PostFilter;
import com.training.ms.gateway.filter.PreFilter;
import com.training.ms.gateway.filter.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulServer
public class EmployeeZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeZuulServiceApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
