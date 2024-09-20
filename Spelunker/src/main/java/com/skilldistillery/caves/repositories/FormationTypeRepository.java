package com.skilldistillery.caves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.caves.entities.FormationType;

public interface FormationTypeRepository extends JpaRepository<FormationType, Integer> {

}
