package com.pratik.spring.constructordependency.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.spring.constructordependency.comman.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
public class DemoController {

	private Coach myCoach;
	
//	private Coach anotherCoach;
	
	@Autowired
	public DemoController(@Qualifier("aquaSide") Coach theCoach) {
	System.out.println("IN Construtor" + getClass().getSimpleName());
		myCoach = theCoach;
//		anotherCoach = theanotherCoach;
		
	}
	
	
	
	
	
//	@Autowired
//	public DemoController(Coach theCoach) {
//		System.out.println("IN Construtor" + getClass().getSimpleName());
//		myCoach = theCoach;
//	}
	
//	@Autowired
//	public void setCoach(Coach theCoach) {
//		myCoach = theCoach;
//	}
	
//	@GetMapping("/check")
//	public String check() {
//		return "Comapring the beans :myCoach = anotherCoach" + (myCoach == anotherCoach);
//	}
	
	@GetMapping("/dailyworkout")
	public String getWorkout() {
		return myCoach.getDailyWorkout();
	}
}
