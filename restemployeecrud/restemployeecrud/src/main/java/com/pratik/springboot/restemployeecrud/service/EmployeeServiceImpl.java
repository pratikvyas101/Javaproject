package com.pratik.springboot.restemployeecrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.pratik.springboot.restemployeecrud.dao.EmployeeRepository;
import com.pratik.springboot.restemployeecrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	// TODO Auto-generated method stub
	
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}
	@Override
	public Employee findById(int Id) {
		// TODO Auto-generated method stub
     Optional<Employee> result = employeeRepository.findById(Id);
     
     Employee theEmployee = null;
    		 if(result.isPresent()) {
    			 theEmployee = result.get();
    		 }
		return theEmployee;
	}
//	@Transactional
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
//	@Transactional
	@Override
	public void deleteById(int Id) {
		employeeRepository.deleteById(Id);
		// TODO Auto-generated method stub
		
	}

}
