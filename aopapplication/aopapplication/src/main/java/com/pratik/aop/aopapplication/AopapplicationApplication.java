package com.pratik.aop.aopapplication;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pratik.aop.aopapplication.dao.AccountDAO;
import com.pratik.aop.aopapplication.dao.MembershipDAO;
import com.pratik.aop.aopapplication.service.TrafficFortuneService;

@SpringBootApplication
public class AopapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopapplicationApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLinner(AccountDAO theAccountDAO,MembershipDAO membershipDAO
										  ,TrafficFortuneService theTrafficFortuneService) {
		return runner->{
//			demotheBeforeAdvice(theAccountDAO,membershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoAfterAdvice(theAccountDAO);
//			demoTheAroundAdvice(theTrafficFortuneService);4
//			demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	} 

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program demoTheAroundAdviceRethrowException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true ;
		
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.print("\n My Forutne is:"+data);
		
		System.out.print("Finished");
		
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true ;
		
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.print("\n My Forutne is:"+data);
		
		System.out.print("Finished");
		
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program demoTheAroundAdvice");
		
		System.out.println("Calling getFortune()");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.print("\n My Forutne is:"+data);
		
		System.out.print("Finished");
		
	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {
		
		List<Account> theAccount = null;
	 	
	 	try {
	 		boolean tripWire = false;
	 		theAccount = theAccountDAO.findAccount(tripWire);
	 	}
	 	catch(Exception ex){
	 		System.out.println("\n\n  Main Program : caught Exception" + ex);
	 		
	 	}
	    
	    System.out.println("\n\n Main Program afterReturning Advice");
	    
	    System.out.println("\n\n");
	    System.out.println(theAccount);
	    
	    System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		 	List<Account> theAccount = null;
		 	
		 	try {
		 		boolean tripWire = true;
		 		theAccount = theAccountDAO.findAccount(tripWire);
		 	}
		 	catch(Exception ex){
		 		System.out.println("\n\n  Main Program : caught Exception" + ex);
		 		
		 	}
		    
		    System.out.println("\n\n Main Program afterReturning Advice");
		    
		    System.out.println("\n\n");
		    System.out.println(theAccount);
		    
		    System.out.println("\n");
		    
		
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
	    List<Account> theAccount = theAccountDAO.findAccount();
	    
	    System.out.println("\n\n Main Program afterReturning Advice");
	    
	    System.out.println("\n\n");
	    System.out.println(theAccount);
	    
	    System.out.println("\n");
	    
		
	}

	private void demotheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO membershipDAO) {
			
			Account theAccount = new Account();
			theAccountDAO.addAccount(theAccount,true);	

			theAccountDAO.setName("Pratik");
			theAccountDAO.setSeriveCode("432323");
			theAccountDAO.doWork();
			
			String Name = theAccountDAO.getName();
			String ServiceCode = theAccountDAO.getSeriveCode();
			
			membershipDAO.addSillyMember();	
			membershipDAO.goToSleep();
	}

}
