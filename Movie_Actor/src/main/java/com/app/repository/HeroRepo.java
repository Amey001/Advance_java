package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Hero;

public interface HeroRepo extends JpaRepository<Hero, Long>{
	
	Optional<Hero> findByemail(String email);
}
