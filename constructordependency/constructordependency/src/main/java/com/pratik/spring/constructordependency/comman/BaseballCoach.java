package com.pratik.spring.constructordependency.comman;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
	
	
	public BaseballCoach(){
		System.out.println("IN Construtor" + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Please if i m wrong you correct me!!!";
	}

}
