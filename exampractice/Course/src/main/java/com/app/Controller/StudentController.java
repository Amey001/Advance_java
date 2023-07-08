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

import com.app.Entities.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService stud;
	
	@GetMapping
	public List<Student> getallStudents()
	{
		System.out.println("getting Student list !!!");
		return stud.getstudentlist();
	}
	
	@PostMapping
	public ResponseEntity<?> addnewStudent(@RequestBody Student student)
	{
		return new ResponseEntity<>(stud.addNewStudent(student),HttpStatus.CREATED);
	}

}
