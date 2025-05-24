package com.skilldistillery.divelog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.divelog.entities.Dive;

public interface DiveRepository extends JpaRepository<Dive, Integer>{

}
