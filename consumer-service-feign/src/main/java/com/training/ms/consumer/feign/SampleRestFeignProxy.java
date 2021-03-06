package com.training.ms.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CircuitBreaker(name = "fallbackService")
@FeignClient(name = "sample-rest", fallback = SampleRestFallback.class)
public interface SampleRestFeignProxy {

	@RequestMapping(path = "/mycall")
//	@CircuitBreaker(name = "fallbackService")
	public String myCall();

	@RequestMapping(path="/mybean")
//	@CircuitBreaker(name = "fallbackService")
	public String mybean();
}
