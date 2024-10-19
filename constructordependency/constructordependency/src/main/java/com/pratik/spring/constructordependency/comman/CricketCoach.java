package com.pratik.spring.constructordependency.comman;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Lazy
public class CricketCoach implements Coach {
	
	public CricketCoach(){
		System.out.println("IN Construtor" + getClass().getSimpleName());
	}
	
	@PostConstruct
	public void doPostMethod() {
		System.out.println("This method is kinf of init" + getClass().getSimpleName());
	}
	
	@PreDestroy
	public void doDestroyMethod() {
		System.out.println("This method is kint of destroy" + getClass().getSimpleName());
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "you should do Daily workoutat least 45 min";
	}

}
