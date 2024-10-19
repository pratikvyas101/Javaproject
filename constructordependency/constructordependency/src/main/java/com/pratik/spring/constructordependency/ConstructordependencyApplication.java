package com.pratik.spring.constructordependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.pratik.spring.constructordependency","com.pratik.spring.util"})
@SpringBootApplication
public class ConstructordependencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructordependencyApplication.class, args);
	}

}
