package com.pratik.springproject.mydemoapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello Worldqsss";
	}
	
	@GetMapping("/workout")
	public String workOut() {
		return "GYM Workout";
	}
}
