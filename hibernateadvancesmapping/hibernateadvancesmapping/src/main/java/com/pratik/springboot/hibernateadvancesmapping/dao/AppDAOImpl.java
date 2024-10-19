package com.pratik.springboot.hibernateadvancesmapping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pratik.springboot.hibernateadvancesmapping.entity.Course;
import com.pratik.springboot.hibernateadvancesmapping.entity.Instructor;
import com.pratik.springboot.hibernateadvancesmapping.entity.InstructorDetail;
import com.pratik.springboot.hibernateadvancesmapping.entity.Review;
import com.pratik.springboot.hibernateadvancesmapping.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class AppDAOImpl implements AppDAO {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public AppDAOImpl(EntityManager theEntityManager) {
		
		this.entityManager =theEntityManager;
		
		
	}

	@Override
	@Transactional
	public void save(Instructor thenInstructor) {
		entityManager.persist(thenInstructor);
		
	}

	@Override
	public Instructor findInstructorById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Instructor.class,theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		List<Course> courses = tempInstructor.getCourses();
		
		for(Course tempCourses : courses) {
			tempCourses.setInstructor(null);
		}
		// TODO Auto-generated method stub
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		
		return  entityManager.find(InstructorDetail.class, theId);
		
	}

	@Override
	@Transactional
	public void deleteInstructorDetailsById(int theId) {
		InstructorDetail tempDetail = entityManager.find(InstructorDetail.class, theId);
		
		tempDetail.getInstructor().setInstructorDetails(null);
		
		entityManager.remove(tempDetail);
		
		
		System.out.println("DONE");
		
	}

	@Override
	public List<Course> findCoursesByInstrucotrId(int theId) {
		// TODO Auto-generated method stub
		
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",Course.class);
		
		query.setParameter("data", theId);
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+ "JOIN FETCH i.courses " + "JOIN FETCH i.instructorDetails " + "where i.id = :data ",Instructor.class);
		
		System.out.println("1st");
		query.setParameter("data",theId);
		
		Instructor instructor = (Instructor)query.getSingleResult();
		
		return instructor;
		
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {
		entityManager.merge(tempInstructor);
		
	}

	@Override
	@Transactional
	public void update(Course tempCourse) {
		entityManager.merge(tempCourse);
		
	}

	@Override
	public Course findCourseById(int theId) {
		return entityManager.find(Course.class, theId);

	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		// TODO Auto-generated method stub
		Course tempCourse = entityManager.find(Course.class, theId);
		
		entityManager.remove(tempCourse);
		
	}

	@Override
	@Transactional
	public void save(Course thecourse) {
		
		entityManager.persist(thecourse); 
		
		
	}

	@Override
	public Course findCourseAndReviewByCourseId(int theId) {
		
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c " + "JOIN FETCH c.reviews " + "where c.id = :data ",Course.class);
		
		query.setParameter("data",theId);
		
		Course course = query.getSingleResult();
		
		return course;
	}

	@Override
	public Course findCourseAndStudentsByCourseId(int theId) {
		// TODO Auto-generated method stub
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c " + "JOIN FETCH c.students " + "where c.id = :data ",Course.class);
		
		query.setParameter("data",theId);
		
		Course course = query.getSingleResult();
		
		return course;
	}

	@Override
	public Student findStudentAndCourseByStudentId(int theId) {
		// TODO Auto-generated method stub
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s " + "JOIN FETCH s.courses " + "where s.id = :data ",Student.class);
		
		query.setParameter("data",theId);
		
		Student theStudent = query.getSingleResult();
		
		return theStudent;
	}

	@Override
	@Transactional
	public void update(Student tempStudent) {
		entityManager.merge(tempStudent);
	}

	@Override
	@Transactional
	public void deleteStudentById(int theId) {
		Student tempStudent = entityManager.find(Student.class, theId);
		
		entityManager.remove(tempStudent);
		
	}

}
