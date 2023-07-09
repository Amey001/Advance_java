package com.app.dtoo;

import com.app.entitries.Hero;
import com.app.entitries.MovieType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Moviedto 
{
	private String moviename;
	  private double budget;
	  private MovieType movietype;
	  private Long hero;
}
