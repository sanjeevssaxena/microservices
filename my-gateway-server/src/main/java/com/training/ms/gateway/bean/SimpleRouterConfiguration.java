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
public class SimpleRouterConfiguration {

	@Bean
	public RouteLocator myRouteConfiguration(RouteLocatorBuilder builder) {
		
		Function<PredicateSpec, Buildable<Route>> fn = (p) -> 
			p.path("/get").uri("http://httpbin.org/get");
			
		Function<PredicateSpec, Buildable<Route>> fnPost = (p) -> 
			p.path("/post").uri("http://httpbin.org/post");
			
		Function<PredicateSpec, Buildable<Route>> fnIntServ = (p) -> 
			p.path("/simple").uri("lb://simple-service");
		
		Function<PredicateSpec, Buildable<Route>> fnRespHeader = (p) -> 
			p.path("/simple").filters(f -> 
			f.addResponseHeader("headerName", "headerValue")).uri("lb://simple-service");
		
		Function<PredicateSpec, Buildable<Route>> fnMetTp = (p) -> 
			p.method(HttpMethod.DELETE).uri("lb://sample-rest");
		
		
		return builder.routes()
				.route(fnMetTp)
				.route(fn)
				.route(fnPost)
				.route(fnIntServ)
				.build();
	}
}
