package com.app.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Custom_exception.ResourceNotFound;
import com.app.dto.HeroDto;
import com.app.entities.Hero;
import com.app.repository.HeroRepo;

@Service
@Transactional
public class HeroServiceImpl implements HeroService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private HeroRepo hrepo;
	
	
	//get 
	@Override
	public List<Hero> getHero() {
		
		return hrepo.findAll();
	}
	
	
	//add newHero
	@Override
	public String addnewHero(HeroDto hero1) {
		
		String msg="cannot add hero";
		Hero hero=mapper.map(hero1, Hero.class);
		//Hero hero=new Hero(hero1.getFirstname(), hero1.getLastname(), hero1.getEmail(), hero1.getPassword(), hero1.getAddress(), hero1.getAge());
		if(hero!=null)
		{
			hrepo.save(hero);
			msg="added hero successfully !!!";
		}
		return msg;
	}

	//delete
	@Override
	public String deleteHero(String email) {
		
		Hero nhero=hrepo.findByemail(email).orElseThrow(()->new ResourceNotFound("cannot fetch hero"));
		hrepo.delete(nhero);
		return "deleted succesfully !!";
	}
	

	
	
	

	
	
	

}
