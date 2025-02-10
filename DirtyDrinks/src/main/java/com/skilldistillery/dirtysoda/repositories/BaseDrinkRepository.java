package com.skilldistillery.dirtysoda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dirtysoda.entities.BaseDrink;

public interface BaseDrinkRepository extends JpaRepository<BaseDrink, Integer> {

}
