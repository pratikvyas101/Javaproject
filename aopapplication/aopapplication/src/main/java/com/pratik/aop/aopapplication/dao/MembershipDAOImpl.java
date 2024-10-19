package com.pratik.aop.aopapplication.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public Boolean addSillyMember() {
		System.out.println("AddAccount in Membership DAO");
		return true;
	}

	@Override
	public void goToSleep() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " i m going to goTosleep");
		
	}

}
