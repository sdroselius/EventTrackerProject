package com.skilldistillery.dirtysoda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dirtysoda.entities.BaseDrink;
import com.skilldistillery.dirtysoda.repositories.BaseDrinkRepository;

@Service
public class BaseDrinkServiceImpl implements BaseDrinkService {

	@Autowired
	private BaseDrinkRepository baseDrinkRepo;
	
	@Override
	public List<BaseDrink> findAll() {
		return baseDrinkRepo.findAll();
	}

	@Override
	public BaseDrink findById(int drinkId) {
		return baseDrinkRepo.findById(drinkId).orElse(null);
	}

	@Override
	public BaseDrink create(BaseDrink newDrink) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseDrink update(int drinkId, BaseDrink drink) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int drinkId) {
		// TODO Auto-generated method stub
		return false;
	}

}
