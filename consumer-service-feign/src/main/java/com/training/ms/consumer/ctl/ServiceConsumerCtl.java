package com.training.ms.consumer.ctl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ms.consumer.feign.SampleRestFeignProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ServiceConsumerCtl {

	Logger log = LoggerFactory.getLogger(ServiceConsumerCtl.class); 
	
	@Autowired
	private SampleRestFeignProxy sampleRestFeign;
	
	@RequestMapping(path = "/feign")
//	@CircuitBreaker(name = "fallbackService", fallbackMethod = "consumeServiceFallback")
	public String consumeService() {
		
		log.debug("Entered consumerService");
		String response = sampleRestFeign.myCall();
		return "Message via Feign: "+response;
	}
	
	/*
	 * public String consumeServiceFallback(Exception e) {
	 * 
	 * return "consumeService is down"; }
	 */
}
