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

		if (employee.getHireDate().getYear() - employee.getDob().getYear() > 18) {
			return employeeRepository.save(employee);
		} else {
			return null;
		}
	}

	/* getting all employees */
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	/* getting single employee */
	public Employee getEmployee(Long employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	/* delete employee */
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}

	/* delete employee by id */
	public void deleteEmployeeById(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
