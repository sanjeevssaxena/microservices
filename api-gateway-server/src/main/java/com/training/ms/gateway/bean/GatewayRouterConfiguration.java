package com.training.ms.gateway.bean;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


@Configuration
public class GatewayRouterConfiguration {
	
	@Bean
	public RouteLocator myRouteConfiguration(RouteLocatorBuilder builder) {
		
		Function<PredicateSpec, Buildable<Route>> fn = 
				(p) -> p.path("/get").uri("http://httpbin.org/");
		
		Function<PredicateSpec,Buildable<Route>> fn2 = 
				(p) -> p.method(HttpMethod.POST).uri("http://httpbin.org/post"); 
				
		Function<PredicateSpec, Buildable<Route>> fn3 = 
				(p) -> p.path("/mybean").uri("lb://sample-rest/*");
				
		Function<PredicateSpec, Buildable<Route>> func4 = 
				(p) -> p.path("/mycall").filters(f -> f.addResponseHeader("myheader", "headerValue"))
						.uri("lb://sample-rest/*");
		return builder.routes()
				.route(fn)
				.route(fn2)
				.route(fn3)
				.route(func4)
				.build();
	}
}
