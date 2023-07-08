package com.app.Service;

import java.util.List;

import com.app.Dto.CourseDto;
import com.app.entities.Course;

public interface CourseService {
	
	List<CourseDto> getCourselist();
	Course addCourse(CourseDto c);

}
