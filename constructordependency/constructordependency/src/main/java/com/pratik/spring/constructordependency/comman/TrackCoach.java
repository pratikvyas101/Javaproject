package com.pratik.spring.constructordependency.comman;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class TrackCoach implements Coach {
	
	
	public TrackCoach(){
		System.out.println("IN Construtor" + getClass().getSimpleName());
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Please do workout at morning at least 20 min";
	}

}
