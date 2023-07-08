package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student extends baseEntity{
	@Column(unique = true,name = "stud",length = 20)
	private String studname;
	@Column(name = "email",length = 30,unique = true)
	private String email;
	
	private double score;
	
	@ManyToOne
	@JoinColumn(name = "course")
	private Course course;

	public Student(String studname, String email, double score) {
		super();
		this.studname = studname;
		this.email = email;
		this.score = score;
	}
	
	
	
	
}
