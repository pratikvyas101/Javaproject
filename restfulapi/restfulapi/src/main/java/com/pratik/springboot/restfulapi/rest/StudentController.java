package com.pratik.springboot.restfulapi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.springboot.restfulapi.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	List<Student>  tempStudent;
	
	@PostConstruct
	public void loadData() {
		tempStudent = new ArrayList<>();
		
		tempStudent.add(new Student("Pratik","vyas"));
		tempStudent.add(new Student("Shivam","patidar"));
		tempStudent.add(new Student("shivam","boss"));
		tempStudent.add(new Student("mohit","joshi"));
		
		
	}

	@GetMapping("/list")
	public List<Student> getListAll(){
		
		return tempStudent;
		
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId >= tempStudent.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id is not Found"+ studentId);
		}
		
		return tempStudent.get(studentId);
		
	}
	
	
}
