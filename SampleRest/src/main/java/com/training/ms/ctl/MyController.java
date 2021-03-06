package com.training.ms.ctl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.training.ms.bean.MyBean;

@RestController
@RefreshScope
public class MyController {
	
	@Value("${message:Hello default}")
	private String message;
	
	@RequestMapping(path = "/mycall")
	public String myCall() {
		
		return "My first call to service with -> :"+message;
	}
	
	@RequestMapping(path="mybean")
	@JsonFormat
	public MyBean mybean() {
		
		MyBean bean = new MyBean();
		
		bean.setId("123");
		bean.setName("name here");
		return bean;
	}

}
