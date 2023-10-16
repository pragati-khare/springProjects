package com.myworkplace.employee_webservice.service;

import java.util.List;

import com.myworkplace.employee_webservice.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deleteById(int theId);
}
