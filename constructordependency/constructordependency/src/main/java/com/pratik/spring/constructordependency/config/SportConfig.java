package com.pratik.spring.constructordependency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pratik.spring.constructordependency.comman.Coach;
import com.pratik.spring.constructordependency.comman.SwimCoach;

@Configuration
public class SportConfig {
	
	@Bean("aquaSide")
	public Coach swimCoach() {
		return new SwimCoach();
	}
	
	

}
