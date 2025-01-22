package com.example.spring.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.config.model.Employee;
import com.example.spring.config.service.NameService;

@RestController
public class EmployeeController {

	@Autowired
	private NameService nameservice;
	
	
	@GetMapping
	@RequestMapping("/api/employees")
	public Employee getEmployeeDetails() {
			Employee emp = new Employee();
			
			emp.setName(nameservice.callNameService());
			emp.setSalary(12345);
            
			return emp;
	}
}
