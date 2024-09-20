package com.skilldistillery.caves.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.caves.entities.CaveVisit;

public interface CaveVisitRepository extends JpaRepository<CaveVisit, Integer>{
	
	List<CaveVisit> findByUser_Id(int userId);
	List<CaveVisit> findByCave_Id(int caveId);

}
