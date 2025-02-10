package com.skilldistillery.dirtysoda.services;

import java.util.List;

import com.skilldistillery.dirtysoda.entities.BaseDrink;

public interface BaseDrinkService {
	List<BaseDrink> findAll();
	BaseDrink findById(int drinkId);
	BaseDrink create(BaseDrink newDrink);
	BaseDrink update(int drinkId, BaseDrink drink);
	boolean deleteById(int drinkId);

}
