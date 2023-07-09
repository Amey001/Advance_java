package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtoo.Herodto;
import com.app.entitries.Hero;

import com.app.service.HeroService;

@RestController
@RequestMapping("/hero")
public class HeroController 
{
  @Autowired
  private HeroService heroservice;
  
  public HeroController()
  {
	  System.out.println(" in cyr of"+getClass());
  }
  @GetMapping
  public List<Hero> getAlllistOfHeros()
  {
	  return heroservice.getAllHeros();
  }
  @PostMapping
  public ResponseEntity<?> insertHeros(@RequestBody Herodto hero)
  {
	  return  new ResponseEntity<>(heroservice.insertheros(hero),HttpStatus.CREATED);
  }
  @DeleteMapping("/{id}")
  public String deleteHeros(@PathVariable Long id)
  {
	  return heroservice.deleteByid(id);
  }
  @PutMapping
  public ResponseEntity<?> updatehero(@RequestBody Hero heros)
  {
	  return new ResponseEntity<>(heroservice.Updateheros(heros),HttpStatus.OK);
  }
  
}
