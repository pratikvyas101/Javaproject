package com.pratik.springboot.hibernateadvancesmapping;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pratik.springboot.hibernateadvancesmapping.dao.AppDAO;
import com.pratik.springboot.hibernateadvancesmapping.entity.Course;
import com.pratik.springboot.hibernateadvancesmapping.entity.Instructor;
import com.pratik.springboot.hibernateadvancesmapping.entity.InstructorDetail;
import com.pratik.springboot.hibernateadvancesmapping.entity.Review;
import com.pratik.springboot.hibernateadvancesmapping.entity.Student;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class HibernateadvancesmappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateadvancesmappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandlineRunner(AppDAO appDAO) {
		return runner -> {
			
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstrucotorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourse(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCourseForInstructor(appDAO);
//			FindInstructorJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
//			deleteCourse(appDAO);
//			createCourseAndReview(appDAO);
//			retriveCourseAndReview(appDAO);
//			deleteCourseAndReview(appDAO);
			
//			createCourseAndStudent(appDAO);
//			findCourseAndStudent(appDAO);
//			findStudentAndCourse(appDAO);
//			addMoreCoursesForStudent(appDAO);
			
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
			
			
		};
	}
	private void deleteStudent(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Delete the Id"+theId);
		
		appDAO.deleteStudentById(theId);
		
		System.out.println("DONE");
		
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent  = appDAO.findStudentAndCourseByStudentId(theId);
		
		Course course1= new Course("Ruby");
		Course course2= new Course("TypeScript");
		
		tempStudent.addCourse(course1);
		tempStudent.addCourse(course2);
		
		System.out.println("tempStudent"+ tempStudent);
		System.out.println("asociated"+ tempStudent.getCourses());
		
		appDAO.update(tempStudent);
		
		System.out.println("DONE");
		
		
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId = 2;
		
		Student theStudent = appDAO.findStudentAndCourseByStudentId(theId);
		
		System.out.println("theStudent is"+theStudent);
		System.out.println("associated with"+theStudent.getCourses());
		
		System.out.println("DONE");
		
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		
		System.out.println("tempCourse"+ tempCourse);
		System.out.println("tempCourse"+ tempCourse.getStudents());
		
		System.out.println("DONE");
		
		
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		Course tempCourse = new Course("SDV DEVELOPER");
		
		Student student1= new Student("pratik","vyas","pratikvyas101@gmail.com");
		Student student2= new Student("sushil","vyas","pratikvyas7146@gmail.com");
		
		tempCourse.addStudent(student1);
		tempCourse.addStudent(student2);
		
		System.out.println("tempCourse saving"+tempCourse);
		
		System.out.println("associated with"+tempCourse.getStudents());
		
		appDAO.save(tempCourse);
		
		System.out.println("DONE");
		
		
	}

	private void deleteCourseAndReview(AppDAO appDAO) {
		int theId = 10 ;
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("DONE");
		
	}

	private void retriveCourseAndReview(AppDAO appDAO) {
		
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);
		
		System.out.println("tempCourse"+tempCourse);
		System.out.println("temp associated"+tempCourse.getReviews());
		
		System.out.println("Done");
		
	}	

	private void createCourseAndReview(AppDAO appDAO) {
		Course tempCourse = new Course("EmbeddedCourse");
		
		tempCourse.addReview(new Review("Greate Course ... loved it!"));
		tempCourse.addReview(new Review("Excellent Course ... loved it!"));
		tempCourse.addReview(new Review("Nice Course ... loved it!"));
		
		System.out.println("tempCourse"+tempCourse);
		System.out.println("associated COurse with"+ tempCourse.getReviews());
		appDAO.save(tempCourse);
		
		System.out.println("DONE");
		
	}

	private void deleteCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		
		Course tempCourse = appDAO.findCourseById(theId);
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("DONE");
		
	}

	private void updateCourse(AppDAO appDAO) {
		
		int theId = 10;
		Course tempCourse = appDAO.findCourseById(theId);
		
		System.out.println("theID is "+ theId);
		tempCourse.setTitle("Vue JS");
		
		appDAO.update(tempCourse);
		
		System.out.print("DONE");
	}

	private void updateInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		
		System.out.println("tempInstructor"+tempInstructor);
		tempInstructor.setFirstName("Pratik");
		System.out.println("Start Update");
		appDAO.update(tempInstructor);
		
		System.out.println("DONE");
	
	}

	private void FindInstructorJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Find the Instructor Id"+theId);
		
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor"+ tempInstructor);
		System.out.println("associate with"+ tempInstructor.getCourses());
		
		System.out.println("DONE");
		
	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor  = appDAO.findInstructorById(theId);
		System.out.println("Instrucotr"+ tempInstructor);
		
		System.out.println("Findig the courses for isntructor id"+theId);
		List<Course> courses = appDAO.findCoursesByInstrucotrId(theId);
		
		tempInstructor.setCourses(courses);
		
		System.out.println("tempInstructor associated courses:"+tempInstructor.getCourses());
		
		System.out.println("DONE");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		Instructor tempInstructor  = appDAO.findInstructorById(theId);
		System.out.println("Instrucotr"+ tempInstructor);
		System.out.println("the associated course"+ tempInstructor.getCourses());
		
	}

	private void createInstructorWithCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		Instructor theInstructor = new Instructor("sushil","vyas","pratikvyas7146@gmail.com");
		
		InstructorDetail tempInstructorDetails = new InstructorDetail("http://www.youtube.com/sushilvyas101","GYM");
		
		theInstructor.setInstructorDetails(tempInstructorDetails);
		
		Course tempCourse1 = new Course("FullStack");
		Course tempCourse2 = new Course("Java");
		Course tempCourse3 = new Course("Android");
		
		theInstructor.add(tempCourse1);
		theInstructor.add(tempCourse2);
		theInstructor.add(tempCourse3);
		
		System.out.println("thetemp"+theInstructor);
		System.out.println("getCourse"+theInstructor.getCourses());
		
		appDAO.save(theInstructor);
		
		System.out.print("DONE");
		
		
		
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		
		int theId = 4;
		appDAO.deleteInstructorDetailsById(theId);
		
		System.out.print("DONE");
		// TODO Auto-generated method stub
		
	}

	private void findInstrucotorDetail(AppDAO appDAO) {
	
		int theId = 3;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		System.out.println("tempInstructorDetails is"+ tempInstructorDetail);
		System.out.print("Details of InstructorDetails"+ tempInstructorDetail.getInstructor());
		
		
		
	}

	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		
		appDAO.delete(theId);
		
		System.out.println("DONE");
		
	}

	private void findInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int theId = 1;
		 Instructor tempInstructor = appDAO.findInstructorById(theId);
		 
		 System.out.println("TempINstructor is"+ tempInstructor);
		 System.out.println("Instructor Details" + tempInstructor.getInstructorDetails());
		
	}

	private void createInstructor(AppDAO appDAO) {
		
		Instructor theInstructor = new Instructor("Pratik","vyas","pratikvyas101@gmail.com");
		
		InstructorDetail tempInstructorDetails = new InstructorDetail("http://www.youtube.com/pratikvyas101","swmming");
		
		theInstructor.setInstructorDetails(tempInstructorDetails);
		
		System.out.println("saving instruction"+ theInstructor);
		
		appDAO.save(theInstructor);
		
		System.out.println("DONE");
		
		
		
	}


}
