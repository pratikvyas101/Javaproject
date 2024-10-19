package com.pratik.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloworldController {

	@RequestMapping("/showForm")
	public String sayForm() {
		
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request,Model model) {
		String theName = request.getParameter("studentName");
		
		String result = theName.toUpperCase();
		
		theName = "Yo !" + result;
		
		model.addAttribute("message",result);
		
		return "helloworld";
		
	}
	
	@PostMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model) {
		
		String result = theName.toUpperCase();
		
		result = "Yo Hello My Friend !" + result;
		
		model.addAttribute("message",result);
		
		return "helloworld";
		
	}
}
