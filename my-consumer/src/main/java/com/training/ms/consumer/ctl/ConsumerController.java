package com.training.ms.consumer.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.ms.consumer.bean.SampleRestProxy;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SampleRestProxy sampleRest;
	
	@RequestMapping(path = "/consume")
	public String consumeService() {
		
		String serviceURL = "http://sample-rest/mycall";
		
//		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.getForEntity(serviceURL, String.class);
		
		return "Got message from service ->" + response.getBody();
	}
	
	
	@RequestMapping(path = "/consumeFeign")
	public String consumeUsingFeign() {
		
		String response = sampleRest.myCall();
		
		return "Open Feign message -> "+ response;
	}
	
}
