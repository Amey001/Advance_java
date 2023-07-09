package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "hero")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreType
public class Hero extends BaseEnitity{
	@Column(name = "fname",length = 20)
	private String firstname;
	@Column(name = "lname",length = 20)
	private String lastname;
	@Column(name = "email",length = 30)
	private String email;
	@Column(name = "password",length = 20)
	private String password;
	@Column(name = "address",length = 50)
	private String address;
	
	private int age;
	
	@OneToMany(mappedBy = "hero",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	private List<Movie> movies=new ArrayList<>();

	public Hero(String firstname, String lastname, String email, String password, String address, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.age = age;
	}
	
	public void addNewMovie(Movie movie)
	{
		movies.add(movie);
	}
	
	public void removeMovie(Movie movie)
	{
		movies.remove(movie);
		movie.setHero(null);
		
	}
	
	
	
}
