package com.pratik.aop.aopapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopapplicationApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLinner(String args[]) {
		return runner->{
			System.out.println("Hello World");
		};
	}

}
