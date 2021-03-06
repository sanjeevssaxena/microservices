package com.training.ms.ctl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api")
@RefreshScope
public class SimpleController {

	@Value("${message:Hello default}")
	private String message;
	
	@GetMapping("/mycall")
	public String myMethodCall() {
		
		return "My first successful REST API : "+message;
	}
}
