package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Course;
import com.app.entities.CourseType;

public interface CourseRepo extends JpaRepository<Course,Long>{
	
	Optional<Course> findByCoursename(CourseType coursename);

}
