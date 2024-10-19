package com.pratik.aop.aopapplication.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pratik.aop.aopapplication.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private String name;
	

	private String seriveCode;
	
	public String getName() {
		System.out.println(getClass() + "getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "setName");
		this.name = name;
	}

	public String getSeriveCode() {
		System.out.println(getClass() + "getSerivceCode");
		return seriveCode;
	}

	public void setSeriveCode(String seriveCode) {
		System.out.println(getClass() + "setServiceCode");
		this.seriveCode = seriveCode;
	}


	@Override
	public void addAccount(Account theAccount,boolean vipFlag) {
		// TODO Auto-generated method stub
		System.out.println("Add Account");
		
	}

	@Override
	public boolean doWork() {
		System.out.println("do work is run");
		return true;
	}

	@Override
	public List<Account> findAccount() {
		
		return findAccount(false);
	}

	@Override
	public List<Account> findAccount(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		 
		List<Account> theAccount = new ArrayList<>();
		
		Account temp1 = new Account("Pratik","golden");
		Account temp2 = new Account("sushil","silver");
		Account temp3 = new Account("shivam","bronze");
		
		theAccount.add(temp1);
		theAccount.add(temp2);
		theAccount.add(temp3);
		return theAccount;
		
	}

}
