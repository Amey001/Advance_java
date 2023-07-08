package com.app.Service;

import java.util.List;

import com.app.Dto.StudentDto;

import com.app.entities.Course;
import com.app.entities.Student;

public interface StudentService {
	
	//get list of students
	List<Student> getlist();
	//add new student
	Student addNewStudent(StudentDto stud);
	//get student by its name
	Student getStudent(String name);
	//update score of student by id
	Student updateStudent(Long id,double score);
	//delete student by email
	//String deletebyemail(String email);
	String deletebyid(Long sid);
	
	
}
