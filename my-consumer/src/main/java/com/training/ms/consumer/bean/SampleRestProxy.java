package com.training.ms.consumer.bean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CircuitBreaker(name = "fallbackService")
@FeignClient(name = "sample-rest", fallback = SampleRestFallback.class)
public interface SampleRestProxy {

	@RequestMapping(path = "/mycall")
	public String myCall();
	
	
}
