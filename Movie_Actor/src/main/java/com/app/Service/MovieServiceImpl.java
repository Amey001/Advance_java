package com.app.Service;

import java.util.ArrayList;
import java.util.List;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Custom_exception.ResourceNotFound;
import com.app.dto.MovieDto;
import com.app.entities.Hero;
import com.app.entities.Movie;
import com.app.entities.MovieType;
import com.app.repository.HeroRepo;
import com.app.repository.MovieRepo;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MovieRepo mrepo;
	
	@Autowired
	private HeroRepo hrepo;
	
	//get
	@Override
	public List<MovieDto> getMovie() {
		
		List<Movie> movielist=mrepo.findAll();
		List<MovieDto> mdtolist=new ArrayList<MovieDto>();
//		movielist.forEach((i)->mdtolist.add(mapper.map(i, MovieDto.class)));
		//mdtolist.forEach((m)->movielist.forEach((s)->m.setHero(s.getHero())));
		
		for(Movie m:movielist)
		{
			mdtolist.add(mapper.map(m,MovieDto.class));
		}
		return mdtolist;
	}
	
	
	//add
	@Override
	public Movie addNewMovie(MovieDto movie1) {
		Hero hero=hrepo.findById(movie1.getHero()).orElseThrow(()->new ResourceNotFound("didnt fetch hero !!"));
		Movie movie=mapper.map(movie1,Movie.class);
		movie.setHero(hero);
		hero.addNewMovie(movie);
		
		return mrepo.save(movie);
	}

	//delete by enum movietype
	@Override
	public String deleteByType(MovieType movietype) {
		String msg="cannot delete Movie";
		
		Movie dmovie=mrepo.findByMovietype(movietype).orElseThrow(()->new ResourceNotFound("cannot fetch the movie !!"));
		if(dmovie!=null)
		{
			mrepo.delete(dmovie);
			msg="Movie by movieType :: "+movietype+" has succefully deleted !!";
			
		}
		return msg;
	}
	
	//update
	
	
	//validate
	
	//public ResponseEntity<?> 
	//get by name
	

}
