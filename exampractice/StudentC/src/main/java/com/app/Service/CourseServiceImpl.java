package com.app.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.CourseDto;
import com.app.entities.Course;
import com.app.repository.CourseRepo;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepo crepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CourseDto> getCourselist() {
	
		List<Course> c=crepo.findAll();
		List<CourseDto> clist=new ArrayList<CourseDto>();
		for(Course c1:c)
		{
			clist.add(mapper.map(c1,CourseDto.class));
		}
		
		return clist;
		
	}
	
	@Override
	public Course addCourse(CourseDto c) {
//		Course c1=new Course(c.getCoursename(), c.getStartDate(),c.getEndDate(),c.getFees(), c.getMinScore());
		Course newc=mapper.map(c,Course.class);
		return crepo.save(newc);
	}

	
	
}
