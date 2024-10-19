package com.pratik.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pratik.springboot.thymeleaf.model.Student;

@Controller
public class studentController {
	
	@Value("${countries}")
	public List<String> countries;
	
	@Value("${languages}")
	public List<String> languages;
	
	@Value("${Systems}")
	public List<String> systems;
	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		
		Student theStudent = new Student();
		
		model.addAttribute("student",theStudent);
		
		model.addAttribute("countries",countries);
		
		model.addAttribute("languages",languages);
		
		model.addAttribute("systems",systems);
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processStudent(@ModelAttribute("student") Student student) {
		
		System.out.println("Student name is"+ student.getFirstName() + "student last name is"+ 
							student.getLastName());
		
		
		return "student-confirmation";
		
	}
}
