package com.pratik.springboot.hibernatecrudejpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pratik.springboot.hibernatecrudejpa.dao.StudentDAO;
import com.pratik.springboot.hibernatecrudejpa.entity.Student;

@SpringBootApplication
public class HibernatecrudejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatecrudejpaApplication.class, args);
	}
	
	@Bean
	public 	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryStudent(studentDAO);
//			queryfindByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		
		Student student1 = new Student("Rohit","Bari","Bari@123.gmail.com");
		Student student2 = new Student("shivam","purohit","purohit@123.gmail.com");
		Student student3 = new Student("mohit","joshi","joshi@123.gmail.com");
		Student tempStudent = new Student("shivam","patidar","patidar@123");
		
		studentDAO.save(student1);
//		studentDAO.save(student2);
//		studentDAO.save(student3);
		studentDAO.save(tempStudent);
		// TODO Auto-generated method stub
		
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int numberRow = studentDAO.deleteAll();
		System.out.println("Number of Rows delete is"+numberRow);
		
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int theid = 2;
		System.out.println("delete Number is"+theid);
		studentDAO.delete(theid);
		
		// TODO Auto-generated method stub
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		
		int theId = 1;
		
		Student tempStudent = studentDAO.findById(theId);
		
		tempStudent.setFirst_name("Shushil");
		studentDAO.update(tempStudent);
		System.out.println("update name is"+tempStudent);
		// TODO Auto-generated method stub
		
	}

	private void queryfindByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		List<Student> theStudent = studentDAO.findByLastName("patidar");
		
		for(Student tempStudent:theStudent) {
			System.out.println("Last Name of the Student is"+tempStudent);
		}
		
	}

	private void queryStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		List<Student> listStudent = studentDAO.findAllStudent();
		
		for(Student theStudent:listStudent) {
			System.out.println("Student list is"+theStudent);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		Student tempStudent = new Student("shivam","patidar","patidar@123");
		
		studentDAO.save(tempStudent);
		
		int theId = tempStudent.getId();
		
		System.out.println("Read from database table id is"+theId);
		
		Student theStudent = studentDAO.findById(theId);
		
		System.out.println("The Student is "+theStudent);
		
		
		
	}

	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		Student tempStudent = new Student("Shubham","boss","boss101@gmail.com");
		
		studentDAO.save(tempStudent);
		
		System.out.println("Student id is"+tempStudent.getId());
		
		
		
		
		
	}

}
