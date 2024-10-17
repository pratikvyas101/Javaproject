package com.pratik.springproject.mydemoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
	
	@Value("${team.name}")
	private String teamName;
	
	@Value("${coach.name}")
	private String coachName;
	
	@GetMapping("/teamDetails")
	public String teamsDetails(){
		return "Teams Name is" + teamName + "coach name is" + coachName;
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello Worldqsss";
	}
	
	@GetMapping("/workout")
	public String workOut() {
		return "GYM Workout";
	}
}
