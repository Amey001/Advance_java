package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.Entities.Course;
import com.app.Repo.CourseRepo;

public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo crepo;
	
	
	@Override
	public List<Course> getAllCourses() {
		
		return crepo.findAll();
	}

	@Override
	public Course AddNewCourse(Course c) {
		
		return crepo.save(c);
	}

}
