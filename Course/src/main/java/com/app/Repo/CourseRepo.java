package com.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
