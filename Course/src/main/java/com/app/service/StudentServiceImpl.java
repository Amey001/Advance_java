package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entities.Student;
import com.app.Repo.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo srepo;
	
	@Override
	public List<Student> getstudentlist() {
		List<Student> list=srepo.findAll();
		return list;
	}

	@Override
	public Student addNewStudent(Student s) {
		
		return srepo.save(s);
	}
	
	

}
