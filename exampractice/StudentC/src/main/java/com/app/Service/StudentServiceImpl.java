package com.app.Service;

import java.util.ArrayList;
import java.util.List;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.CustomException.ResourceNotFoundExcept;
import com.app.Dto.StudentDto;

import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repository.CourseRepo;
import com.app.repository.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo srepo;
	
	@Autowired
	private CourseRepo crepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<Student> getlist() {

		return srepo.findAll();
	}
	
	@Override
	public Student addNewStudent(StudentDto stud) {
		//fetch course by courseid
		Course course=crepo.findById(stud.getCourse()).orElseThrow(()->new ResourceNotFoundExcept("error in fetching the error !!"));
		Student student=mapper.map(stud,Student.class);
		student.setCourse(course);
		course.addNewStudent(student);
		
		return srepo.save(student);
	}

	@Override
	public Student getStudent(String name) {
		
		Student stud=srepo.findByStudname(name).orElseThrow(()->new ResourceNotFoundExcept("fetching Student Failed !!!"));
		
		return stud;
	}

	@Override
	public Student updateStudent(Long id, double score) {
		Student stud=srepo.findById(id).orElseThrow(()->new ResourceNotFoundExcept("cannot fetch data !!"));
		stud.setScore(score);
		return srepo.save(stud);
	}

	@Override
	public String deletebyid(Long sid) {
		String mesg="cannot delete the student !!!";
		System.out.println("id in Service :: "+sid);
		if(srepo.existsById(sid))
		{
			System.out.println("check1");
			srepo.deleteById(sid);
			mesg="deleted successfully !!";
		}
		System.out.println("check2");
		return mesg;
	}

}
