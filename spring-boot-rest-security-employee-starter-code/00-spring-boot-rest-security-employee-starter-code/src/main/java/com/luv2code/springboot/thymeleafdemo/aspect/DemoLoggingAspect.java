package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	private Logger myLogger= Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
	public void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
	public void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {
		
	}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("======> @Before: Method is calling "+theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg:args) {
			myLogger.info("==>> Argrument:"+tempArg);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("======> @Before: Method is calling "+theMethod);
		
		myLogger.info("====>result:"+theResult);
	}
}
