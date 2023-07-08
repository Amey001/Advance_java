package com.app.Service;

import java.util.List;

import com.app.Dto.ApiResponse;
import com.app.Dto.CourseDto;
import com.app.entities.Course;
import com.app.entities.CourseType;

public interface CourseService {
	
	List<CourseDto> getCourselist();
	Course addCourse(CourseDto c);
	Course getCourse(CourseType coursename);
	Course updatebyid(Long id,int fee);
	ApiResponse delete(Long id);

}
