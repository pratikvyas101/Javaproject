package com.pratik.springboot.restemployeecrud.rest;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pratik.springboot.restemployeecrud.entity.Employee;
import com.pratik.springboot.restemployeecrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService= theEmployeeService;
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllList(){
		
		return employeeService.findAll();
		
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee does not exist");
		}
		
		return theEmployee;
		
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		System.out.println("Object is"+theEmployee.getFirstName());
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String  deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null ) {
			throw new RuntimeException("The EmployeeId"+employeeId); 
		}
		employeeService.deleteById(employeeId);
		
		return "delete the EmployeeId is" + theEmployee;
		
	}

}
