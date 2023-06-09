package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// add a method for auth
	Optional<Employee> findByEmailAndPassword(String em, String pass); 
	//if we written emp we have to do null checking
}
