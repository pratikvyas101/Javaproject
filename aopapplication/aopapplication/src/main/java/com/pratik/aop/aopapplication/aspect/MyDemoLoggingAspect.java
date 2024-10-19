package com.pratik.aop.aopapplication.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pratik.aop.aopapplication.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.pratik.aop.aopapplication.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n ===> Execuation Method @Around (aroundGetFortune) Method "+ method);
		
		long begin  = System.currentTimeMillis();
		
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		}
		catch(Exception exc) {
			System.out.println(exc.getMessage());
			throw exc;
//			result = "Major accident ! But no worries ,your private AOP is on the way";
		}
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		System.out.println("\n=====> Duration" +duration / 10000.0 + "seconds");
		
		return result;
	}
	
	@After("execution(* com.pratik.aop.aopapplication.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ===> Execuation Method (finally) Method "+ method);
		
		
	}
	
	@AfterThrowing(pointcut = "execution(* com.pratik.aop.aopapplication.dao.AccountDAO.findAccount(..))",throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint  theJoinPoint , Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n ===> Execuation Method @AfterThrowning "+ method);
		
		System.out.println("\n ");
		
		System.out.println("=====>Exception: "+theExc);
		
	}
	
	@AfterReturning(pointcut="execution(* com.pratik.aop.aopapplication.dao.AccountDAO.findAccount(..))",returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint,List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n ===> Execuation Method @AfterRetuning "+ method);
		
		System.out.println("\n ");
		
		System.out.println("=====>Result: "+result);
		
		convertAccountNamesToUppercase(result);
		
	}
	
	
	private void convertAccountNamesToUppercase(List<Account> result) {
		
		for(Account tempAccount:result) {
			
			String tempUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(tempUpperName);
		}
		
	}


	@Before("com.pratik.aop.aopapplication.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) 
	{
		MethodSignature  methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.print("\n Method:" +methodSignature);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name:"+theAccount.getName());
				System.out.println("account level:"+theAccount.getLevel());
				
			}
		}
		
		System.out.print("Exceuction @ Before addAccount Method");
	}
	
//		@Pointcut("execution(* com.pratik.aop.aopapplication.*.*(..))")
//		public void forDAOPackage() {}
//	
//		@Pointcut("execution(* com.pratik.aop.aopapplication.*.get*(..))")
//		private void getter() {
//			
//		}
//		
//		
//		@Pointcut("execution(* com.pratik.aop.aopapplication.*.set*(..))")
//		private void setter() {
//			
//		}
//		@Pointcut("forDAOPackage() && !(getter() || setter())")
//		private void forDaoPackageNoGetterSetter() {
//			
//		}
//		
		
//		@Before("forDAOPackage()")
//		public void beforeAddAccountAdvice() 
//		{
//			System.out.print("Exceuction @ Before addAccount Method");
//		}
		

		

		
		
	

}
