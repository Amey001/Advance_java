package com.app.service;

import java.util.ArrayList;
import java.util.List;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtoo.Moviedto;
import com.app.entitries.Hero;
import com.app.entitries.Movie;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.HeroRepository;
import com.app.repository.MovieRepository;

@Service

@Transactional

public class MovieServiceImpl implements MovieService 
{
   @Autowired
   private MovieRepository movieRepo;
   @Autowired
   private HeroRepository heroRepo;
   @Autowired
   private ModelMapper mapper;
	@Override
	public java.util.List<Movie> getAllMovies() {
		
//		List<Movie> m= movieRepo.findAll();
//		List<Moviedto> m1=new ArrayList<>();
		return movieRepo.findAll();
		
	}
	@Override
	public Movie insertMovies(Moviedto movies) {
	Hero hero=heroRepo.findById(movies.getHero()).orElseThrow(()->new ResourceNotFoundException("hero is not found"));
	Movie movie=mapper.map(movies,Movie.class);
	movie.setHero(hero);
	//System.out.println(" hero dhid "+movie+hero);
		return movieRepo.save(movie) ;
	}


	@Override
	public Movie updatemovie(Movie movies) {
		
		return movieRepo.save(movies);
	}
	@Override
	public String deleteBYid(Long id) {
		String mesg=" movie id is not found";
		if(movieRepo.existsById(id))
		{
			movieRepo.deleteById(id);
			return mesg=" Movies is deleted";
		}
		return mesg;
	}
	
	
 
}
