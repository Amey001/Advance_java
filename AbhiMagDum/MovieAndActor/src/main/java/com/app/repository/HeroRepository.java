package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entitries.Hero;

public interface HeroRepository  extends JpaRepository<Hero, Long>
{
    
}
