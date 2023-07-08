package com.app.service;

import java.util.List;

import com.app.Entities.Course;

public interface CourseService {
	List<Course> getAllCourses();
	
	Course AddNewCourse(Course c);
}
