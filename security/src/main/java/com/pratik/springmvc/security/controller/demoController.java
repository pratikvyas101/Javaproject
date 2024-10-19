package com.pratik.springmvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demoController {

	@GetMapping("/")
	public String sayHello() {
		
		return "home";
	}
	
	@GetMapping("/leaders")
	public String sayleaders() {
		
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String saySystem() {
		
		return "systems";
	}
	@GetMapping("/access-denied")
	public String showaccessDenied() {
		
		return "access-denied";
	}
	
}
