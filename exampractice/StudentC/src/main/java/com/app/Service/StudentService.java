package com.app.Service;

import java.util.List;

import com.app.Dto.StudentDto;

import com.app.entities.Course;
import com.app.entities.Student;

public interface StudentService {
	
	List<Student> getlist();
	Student addNewStudent(StudentDto stud);
	Student getStudent(String name);
	Student updateStudent(Long id,double score);
	
}
