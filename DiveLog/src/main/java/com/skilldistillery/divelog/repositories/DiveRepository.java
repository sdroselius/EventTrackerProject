package com.skilldistillery.divelog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.divelog.entities.Dive;

public interface DiveRepository extends JpaRepository<Dive, Integer>{
	
	List<Dive> findByUser_Username(String username);
	Dive findByIdAndUser_Username(int diveId, String username);

}
