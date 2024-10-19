package com.pratik.aop.aopapplication.dao;

import java.util.List;

import com.pratik.aop.aopapplication.Account;

public interface AccountDAO {
	
	public void addAccount(Account theAccount,boolean vipFlag);
	
	List<Account> findAccount();
	List<Account> findAccount(boolean tripWire);
	
	boolean doWork();
	
	public String getName();

	public void setName(String name);

	public String getSeriveCode();

	public void setSeriveCode(String seriveCode);

}
