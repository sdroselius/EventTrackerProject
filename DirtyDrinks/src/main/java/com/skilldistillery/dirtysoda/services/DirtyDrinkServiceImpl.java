package com.skilldistillery.dirtysoda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dirtysoda.entities.DirtyDrink;
import com.skilldistillery.dirtysoda.repositories.DirtyDrinkRepository;

@Service
public class DirtyDrinkServiceImpl implements DirtyDrinkService {
	
	@Autowired
	private DirtyDrinkRepository drinkRepo;

	@Override
	public List<DirtyDrink> findAll() {
		return drinkRepo.findAll();
	}

	@Override
	public DirtyDrink findById(int drinkId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirtyDrink create(DirtyDrink newDrink) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirtyDrink update(int drinkId, DirtyDrink drink) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int drinkId) {
		// TODO Auto-generated method stub
		return false;
	}

}
