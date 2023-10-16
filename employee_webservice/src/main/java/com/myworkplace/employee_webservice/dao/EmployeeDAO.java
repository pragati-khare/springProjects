package com.myworkplace.employee_webservice.dao;

import java.util.List;

import com.myworkplace.employee_webservice.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deleteById(int theId);

}
