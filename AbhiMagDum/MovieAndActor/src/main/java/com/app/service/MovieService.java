package com.app.service;

import java.util.List;

import com.app.dtoo.Moviedto;
import com.app.entitries.Movie;


public interface MovieService 
{
	 List<Movie> getAllMovies();
	 Movie insertMovies(Moviedto movies);
	 String deleteBYid(Long id);
	 Movie updatemovie(Movie movies);
}
