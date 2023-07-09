package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.MovieService;
import com.app.dto.MovieDto;
import com.app.entities.MovieType;

@RestController
@RequestMapping("/movie")

public class MovieController {
	
	@Autowired
	private MovieService mservice;
	
	//get
	
	@GetMapping
	public ResponseEntity<?> getMovie()
	{
		return ResponseEntity.status(HttpStatus.OK).body(mservice.getMovie());
	}
	
	
	//add
	@PostMapping
	public ResponseEntity<?> addNewMovie(@RequestBody MovieDto movie1)
	{
		return new ResponseEntity<>( mservice.addNewMovie(movie1),HttpStatus.CREATED);
	}
	
		//delete
	@DeleteMapping("/{type}")
	public ResponseEntity<?> deleteMovie(@RequestBody @PathVariable String type)
	{
		MovieType type1=MovieType.valueOf(type);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
		
		//update
		
		//validate
		
		//get by name
	
	
	

}
