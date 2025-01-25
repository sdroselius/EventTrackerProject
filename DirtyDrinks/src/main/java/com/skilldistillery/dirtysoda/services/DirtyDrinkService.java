package com.skilldistillery.dirtysoda.services;

import java.util.List;

import com.skilldistillery.dirtysoda.entities.DirtyDrink;

public interface DirtyDrinkService {
	List<DirtyDrink> findAll();
	DirtyDrink findById(int drinkId);
	DirtyDrink create(DirtyDrink newDrink);
	DirtyDrink update(int drinkId, DirtyDrink drink);
	boolean deleteById(int drinkId);

}
