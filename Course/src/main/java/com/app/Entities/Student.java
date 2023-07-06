package com.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="studentdetails")

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "password")
@JsonIgnoreType

public class Student extends BaseEntity{
	//first name , last name , email , course title,score obtained.
	
	@Column(name="fname",length = 20)
	private String fname;
	
	@Column(name="lname",length = 20)
	private String lname;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 30)
	private String password;
	
	private double score;
	@Enumerated(EnumType.STRING)
	private CourseEnum cname; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_id",nullable = false)
	private Course title;
	
	public Student(String fname, String lname, String email, double score, CourseEnum cname) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.score = score;
		this.cname = cname;
	}
	

}
