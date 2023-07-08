package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "course")
@JsonIgnoreType
public class Course extends baseEntity{
	
	//CourseDetail courseTitle, LocalDate startDate, LocalDate endDate, int fees, int minScore
	@Enumerated(EnumType.STRING)
	@Column(name = "cname")
	private CourseType coursename;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private int fees;
	private int minScore;
	
	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Student> studentlist=new ArrayList<Student>();

	//constructor
	public Course(CourseType coursename, LocalDate startDate, LocalDate endDate, int fees, int minScore) {
		super();
		this.coursename = coursename;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fees = fees;
		this.minScore = minScore;
	}
	
	public void addNewStudent(Student student)
	{
		studentlist.add(student);
		
	}
	
	public void removeStudent(Student student) 
	{
		studentlist.remove(student);
		student.setCourse(null);
	}
	 
	
	
}
