package dao;

import java.util.List;

import pojos.Student;

public interface StudentDao {

	String insertStudent(Student student);
	String StudLogin(String email,String pass);
}
