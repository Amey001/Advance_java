package com.app.service;

import java.util.List;

import com.app.Entities.Student;

public interface StudentService {
	List<Student> getstudentlist();
	Student addNewStudent(Student s);
}
