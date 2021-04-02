package com.skilldistillery.lemurs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.lemurs.entities.Lemur;

public interface LemurRepository extends JpaRepository<Lemur, Integer> {

}
