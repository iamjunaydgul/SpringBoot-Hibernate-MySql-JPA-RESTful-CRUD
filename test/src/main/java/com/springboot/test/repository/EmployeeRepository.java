package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
