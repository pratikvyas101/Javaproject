package com.pratik.springboot.hibernatecrudejpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pratik.springboot.hibernatecrudejpa.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private EntityManager entityManager;
	
	

	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
		
	}



	@Override
	@Transactional
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class,id);
	}



	@Override
	@Transactional
	public List<Student> findAllStudent(){
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
		
		return theQuery.getResultList();
	}



	@Override
	@Transactional
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		theQuery.setParameter("theData",theLastName);
		return theQuery.getResultList();
	}



	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		// TODO Auto-generated method stub
		
	}



	@Override
	@Transactional
	public void delete(Integer theId) {
		Student tempStudent = entityManager.find(Student.class, theId);
		entityManager.remove(tempStudent);
		// TODO Auto-generated method stub
		
	}



	@Override
	@Transactional
	public int deleteAll() {
		int numberRow = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		
		// TODO Auto-generated method stub
		return numberRow;
	}

}
