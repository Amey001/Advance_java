package com.app.Service;

import java.util.List;

import com.app.dto.MovieDto;
import com.app.entities.Movie;
import com.app.entities.MovieType;

public interface MovieService {
	
	//add new movie
	Movie addNewMovie(MovieDto movie1);
	//get movie list
	List<MovieDto> getMovie();
	
	//delete movie by its type
	String deleteByType(MovieType movietype);
	

}
