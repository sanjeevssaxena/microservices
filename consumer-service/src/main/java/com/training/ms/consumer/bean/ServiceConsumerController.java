package com.training.ms.consumer.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path = "/consume")
	public String consumeService() {
//		RestTemplate restTemplate = new RestTemplate();
		String serviceURL = "http://sample-rest/mycall";
		ResponseEntity<String> response = restTemplate.getForEntity(serviceURL, String.class);
		System.out.println("Response from : "+response.getBody());
		
		return "Mesage from SampleRest:- "+response.getBody();
	}
	
}
