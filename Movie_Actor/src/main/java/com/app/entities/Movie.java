package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "movie")

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class Movie extends BaseEnitity{

	@Column(name = "moviename",length = 20,unique = true)
	private String moviename;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "movietype")
	private MovieType movietype;
	
	private double Budget;
	
	@ManyToOne
	@JoinColumn(name = "hero")
	private Hero hero;

	public Movie(String moviename, MovieType movietype, double budget) {
		super();
		this.moviename = moviename;
		this.movietype = movietype;
		Budget = budget;
	}
	
	
	
}
