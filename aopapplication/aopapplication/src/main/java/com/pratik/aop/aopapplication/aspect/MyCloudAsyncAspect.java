package com.pratik.aop.aopapplication.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {
	
	@Before("com.pratik.aop.aopapplication.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() 
	{
		System.out.print("logging to cloud async fashion");
	}
}
