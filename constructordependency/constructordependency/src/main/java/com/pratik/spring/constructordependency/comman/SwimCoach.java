package com.pratik.spring.constructordependency.comman;

public class SwimCoach implements Coach {
	
	public SwimCoach(){
		System.out.println("In Constructor"+ getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swiming is my passion";
	}

}
