package com.skilldistillery.dirtysoda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dirtysoda.entities.DirtyDrink;

public interface DirtyDrinkRepository extends JpaRepository<DirtyDrink, Integer> {

}
