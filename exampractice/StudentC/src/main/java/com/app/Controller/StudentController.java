package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.StudentDto;

import com.app.Service.StudentService;
import com.app.entities.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@GetMapping
	public List<Student> getStudentList()
	{	
//		return ResponseEntity.status(HttpStatus.OK).body(sService.getlist());
		return sService.getlist();
	}
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addnewStudent(@RequestBody StudentDto stud)
	{
		return new ResponseEntity<>(sService.addNewStudent(stud), HttpStatus.CREATED);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name)
	{
		return ResponseEntity.status(HttpStatus.OK).body(sService.getStudent(name));
	}
	
	@PutMapping("/{id}/{score}")
	public Student updateStudent(@PathVariable Long id,@PathVariable double score)
	{
		return sService.updateStudent(id, score);
	}

}
