package com.skilldistillery.divelog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.divelog.entities.DiveSite;

public interface DiveSiteRepository extends JpaRepository<DiveSite, Integer> {
	List<DiveSite> findByDestination_Id(int destId);
}
