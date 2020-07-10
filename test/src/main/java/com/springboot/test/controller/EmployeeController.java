package com.springboot.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.dao.EmployeeDAO;
import com.springboot.test.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	/* saving employee into database */
	@PostMapping("/employees")
	public Employee creatingEmployee(@Valid @RequestBody Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	/* getting all employees */
	@GetMapping("/employees")
	public List<Employee> gettingEmployees() {
		return employeeDAO.getEmployees();
	}

	/* getting single employee by id */
	@GetMapping("/notes/{id}")
	public ResponseEntity<Object> gettingEmployee(@PathVariable(value = "id") Long employeeID) {
		Employee emp = employeeDAO.getEmployee(employeeID);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(emp);
		}
	}

	/* updating employee */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updatingEmployee(@PathVariable(value = "id") Long employeeID,
			@Valid @RequestBody Employee employeeDetails) {
		Employee emp = employeeDAO.getEmployee(employeeID);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		} else {
			emp.setFirstName(employeeDetails.getFirstName());
			emp.setLastName(employeeDetails.getLastName());

			emp.setSsn(employeeDetails.getSsn());
			emp.setDob(employeeDetails.getDob());
			emp.setHireDate(employeeDetails.getHireDate());

			Employee updateEmployee = employeeDAO.addEmployee(emp);
			return ResponseEntity.ok().body(updateEmployee);
		}

	}

	/* deleting employee */
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long employeeID) {
		Employee emp = employeeDAO.getEmployee(employeeID);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		} else {
			employeeDAO.deleteEmployee(emp);
			return ResponseEntity.ok().build();
		}
	}
}
