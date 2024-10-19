package com.pratik.aop.aopapplication.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class LuvAopExpression {
	
	@Pointcut("execution(* com.pratik.aop.aopapplication.*.*(..))")
	public void forDAOPackage() {}

	@Pointcut("execution(* com.pratik.aop.aopapplication.*.get*(..))")
	public  void getter() {
		
	}
	
	
	@Pointcut("execution(* com.pratik.aop.aopapplication.*.set*(..))")
	public  void setter() {
		
	}
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
		
	}

}
