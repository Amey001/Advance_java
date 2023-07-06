package com.app.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="course")
@Getter
@Setter
@NoArgsConstructor
@ToString()
@JsonIgnoreType
public class Course extends BaseEntity{
	
	//course title(unique) , start date , end date , fees , min score
	@Enumerated(EnumType.STRING)
	private CourseEnum coursetitle;
	
	private LocalDate startdate;
	
	private LocalDate enddate;
	
	private Integer fee;
	
	private Integer minscore;
	@OneToMany(mappedBy = "title",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Student> students=new ArrayList<>();

	public Course(CourseEnum coursetitle, LocalDate startdate, LocalDate enddate, Integer fee, Integer minscore) {
		super();
		this.coursetitle = coursetitle;
		this.startdate = startdate;
		this.enddate = enddate;
		this.fee = fee;
		this.minscore = minscore;
	}
	
	
	

}
