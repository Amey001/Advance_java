package com.app.Dto;

import java.time.LocalDate;

import com.app.entities.CourseType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CourseDto {

	private CourseType coursename;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int fees;
	private int minScore;
	
}
