package com.pratik.springboot.restemployeecrud.service;

import java.util.List;

import com.pratik.springboot.restemployeecrud.entity.Employee;

public interface EmployeeService {
   public List<Employee> findAll();
   
   Employee findById(int Id);
   
   Employee save(Employee employee);
   
   public void deleteById(int Id);
}
