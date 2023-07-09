package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Movie;
import com.app.entities.MovieType;



public interface MovieRepo extends JpaRepository<Movie,Long>{
	
	Optional<Movie> findByMovietype(MovieType movietype);

}
