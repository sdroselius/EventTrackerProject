package com.skilldistillery.caves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.caves.entities.Cave;

public interface CaveRepository extends JpaRepository<Cave, Integer> {

}
