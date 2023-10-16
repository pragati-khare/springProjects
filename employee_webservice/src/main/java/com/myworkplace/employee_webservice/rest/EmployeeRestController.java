package com.myworkplace.employee_webservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myworkplace.employee_webservice.entity.Employee;
import com.myworkplace.employee_webservice.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee= employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee not found - "+employee);
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable int employeeId) {
		Employee employee=employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee not found-"+ employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted Employee - " + employeeId;
	}

}
