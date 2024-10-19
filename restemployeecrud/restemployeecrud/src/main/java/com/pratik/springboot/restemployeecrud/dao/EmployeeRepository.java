package com.pratik.springboot.restemployeecrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratik.springboot.restemployeecrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
