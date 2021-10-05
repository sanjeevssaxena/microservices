package com.training.ms.consumer.bean;

import org.springframework.stereotype.Component;

@Component
public class SampleRestFallback implements SampleRestProxy {

	@Override
	public String myCall() {

		return "Alternate data from fallback";
	}

}
