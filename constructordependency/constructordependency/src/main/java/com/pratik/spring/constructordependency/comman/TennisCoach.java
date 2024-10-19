package com.pratik.spring.constructordependency.comman;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennisCoach implements Coach {
	
	
	public TennisCoach(){
		System.out.println("IN Construtor" + getClass().getSimpleName());
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "you should play tenis in your office";
	}

}
