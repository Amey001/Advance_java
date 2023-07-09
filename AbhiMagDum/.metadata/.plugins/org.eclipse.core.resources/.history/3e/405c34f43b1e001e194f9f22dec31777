package com.app.entitries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="movies")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class Movie extends BaseIntity
{
	@Column(name="movie_name",unique = true)
  private String moviename;
	@Column(name="budget",length = 20)
  private double budget;
 
  @ManyToOne
  private Hero hero;
  @Enumerated(EnumType.STRING)
  private MovieType movietype;
  
}
