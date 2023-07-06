package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService course;
	
	@GetMapping
	public List<Course> getAllCourses()
	{
		List<Course> list=course.getAllCourses();
		return list;
	}
	
	@PostMapping
	public ResponseEntity<?> addnewCourses(@RequestBody Course c)
	{
		return new ResponseEntity<>(course.AddNewCourse(c),HttpStatus.CREATED);
	}
	
	
}
