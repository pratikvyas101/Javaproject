package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theemployeeService) {
		employeeService = theemployeeService;
	}
	
	@GetMapping("/list")
	public String getList(Model model){
		List<Employee> theEmployee = employeeService.findAll();
		
		model.addAttribute("employee",theEmployee);
		
		return "employees/list-employee";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee theEmployee = new Employee();
		
		model.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormForUpdateEmployee(@RequestParam("employeeId") int theId,Model model) {
		Employee theEmployee = employeeService.findById(theId);
		
		model.addAttribute("employee",theEmployee);
		
		return "/employees/employee-form";
		
	}
	@GetMapping("/delete")
	public String delelteEmployee(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteById(theId);
		
		return "employees/list-employee";
	}
	
}
