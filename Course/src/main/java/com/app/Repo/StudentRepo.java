package com.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
	
}
