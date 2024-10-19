package com.pratik.springboot.validation.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation){
		coursePrefix=constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean  result ;
		if(value!= null) {
			
			result = value.startsWith(coursePrefix);
		}else {
			result =true;
		}
		return result;
	}

}
