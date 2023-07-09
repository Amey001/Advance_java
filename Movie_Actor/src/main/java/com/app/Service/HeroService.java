package com.app.Service;

import java.util.List;

import com.app.dto.HeroDto;
import com.app.entities.Hero;

public interface HeroService {

	//add new hero
	String addnewHero(HeroDto hero1);
	
	//get the hero
	List<Hero> getHero();
	
	//delete hero
	String deleteHero(String email);
	
	
}
