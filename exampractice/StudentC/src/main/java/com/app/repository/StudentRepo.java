package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{

	Optional<Student> findByStudname(String name);
}
