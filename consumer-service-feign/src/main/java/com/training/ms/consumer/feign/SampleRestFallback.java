package com.training.ms.consumer.feign;

import org.springframework.stereotype.Component;

@Component
public class SampleRestFallback implements SampleRestFeignProxy {

	@Override
	public String myCall() {
		// TODO Auto-generated method stub
		return "mycall method Getting error as service is down";
	}

	@Override
	public String mybean() {
		// TODO Auto-generated method stub
		return "mybean method Getting error as service is down";
	}

}
