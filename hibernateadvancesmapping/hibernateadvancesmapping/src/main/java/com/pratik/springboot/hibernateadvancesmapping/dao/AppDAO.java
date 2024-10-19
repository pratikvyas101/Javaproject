package com.pratik.springboot.hibernateadvancesmapping.dao;

import java.util.List;

import com.pratik.springboot.hibernateadvancesmapping.entity.Course;
import com.pratik.springboot.hibernateadvancesmapping.entity.Instructor;
import com.pratik.springboot.hibernateadvancesmapping.entity.InstructorDetail;
import com.pratik.springboot.hibernateadvancesmapping.entity.Student;

public interface AppDAO {
   
	void save(Instructor thenInstructor);
	
	Instructor findInstructorById(int theId);
	
	void delete(int theId);
	
	InstructorDetail findInstructorDetailById(int theId);
	
	void deleteInstructorDetailsById(int theId);
	
	List<Course> findCoursesByInstrucotrId(int theId);
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor tempInstructor);
	
	void update(Course tempCourse);
	
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);
	
	void save(Course thecourse);
	
	Course findCourseAndReviewByCourseId(int theId);
	
	Course findCourseAndStudentsByCourseId(int theId);
	
	Student findStudentAndCourseByStudentId(int theId);
	
	void update(Student tempStudent);
	
	void deleteStudentById(int theId);
	
	
	
	
}
