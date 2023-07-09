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

import com.app.Service.HeroService;
import com.app.dto.HeroDto;

@RestController
@RequestMapping("/hero")
public class HeroController {
	
	@Autowired
	private HeroService hservice;
	
		//get
	@GetMapping
	public ResponseEntity<?> getHero()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hservice.getHero());
	}
	
		//add

	@PostMapping("/addhero")
	public ResponseEntity<?> addnewHero(@RequestBody HeroDto hero)
	{
		return new ResponseEntity<>(hservice.addnewHero(hero), HttpStatus.CREATED);
	}
		//delete
	@DeleteMapping("{email}")
	public ResponseEntity<?> deleteHero(@RequestBody @PathVariable String email)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hservice.deleteHero(email));
	}
		
		//update
		
		//validate
		
		//get by name

}
