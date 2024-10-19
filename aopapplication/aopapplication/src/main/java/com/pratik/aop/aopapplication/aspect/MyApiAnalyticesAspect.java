package com.pratik.aop.aopapplication.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticesAspect {

	@Before("com.pratik.aop.aopapplication.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void performApiAnalytices() 
	{
		System.out.print("Exceuction @ Before addAccount performApiAnalytices");
	}
}
