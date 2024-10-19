package com.pratik.springboot.hibernatecrudejpa.dao;

import java.util.List;

import com.pratik.springboot.hibernatecrudejpa.entity.Student;

public interface StudentDAO {
	
	public void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAllStudent();
	
	List<Student> findByLastName(String theLastName);
	
	public void update(Student theStudent);
	
	public void delete(Integer theId);
	
	public int deleteAll();

}
