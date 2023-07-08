package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.CourseDto;
import com.app.Service.CourseService;
import com.app.entities.Course;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
		
	@Autowired
	private CourseService cservice;
	
	//get the course list
	@GetMapping
	public List<CourseDto> getlist()
	{
		return cservice.getCourselist();
	}
	
	//add a new Course
	@PostMapping("/addcourse")
	public ResponseEntity<?> addNewCourse(@RequestBody CourseDto c)
	{
		return new ResponseEntity<>(cservice.addCourse(c),HttpStatus.CREATED);
	}
	
	
}
