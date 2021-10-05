package com.training.ms.simple.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@RequestMapping(path = "/simple")
	public String mySimple() {
		
		return "my simple service";
	}
}
