package com.springboot.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.model.Employee;
import com.springboot.test.repository.EmployeeRepository;


@Service
public class EmployeeDAO {
	@Autowired
	EmployeeRepository employeeRepository;
	
	/* adding employee */
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/* getting all employees */
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	/* getting employee single employee*/
	public Employee getEmployee(Long employeeID) {
		return employeeRepository.getOne(employeeID);
	}
	
	/* delete employee */
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}
}
