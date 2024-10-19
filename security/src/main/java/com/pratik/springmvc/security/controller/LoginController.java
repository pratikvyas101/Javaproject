package com.pratik.springmvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
   
	@GetMapping("/showMyLoginPage")
	public String showMyLoginForm() {
//		return "plain-login";
		return "fancy-login";
	}
}
