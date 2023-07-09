package com.app.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HeroDto {
	
	private String firstname;
	private String lastname;
	private String email;
	
	private String password;

	private String address;
	
	private int age;
	
}
