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
		return drinkRepo.findById(drinkId).orElse(null);
	}

	@Override
	public DirtyDrink create(DirtyDrink newDrink) {
		newDrink.setEnabled(true);
		return drinkRepo.saveAndFlush(newDrink);
	}

	@Override
	public DirtyDrink update(int drinkId, DirtyDrink drink) {
		DirtyDrink managed = drinkRepo.findById(drinkId).orElse(null);
		if (managed != null) {
			managed.setBrand(drink.getBrand());
			managed.setDescription(drink.getDescription());
			managed.setImageUrl(drink.getImageUrl());
			managed.setName(drink.getName());
			if (drink.getBaseDrink() != null) {
				managed.setBaseDrink(drink.getBaseDrink());
			}
			return drinkRepo.saveAndFlush(managed);
		}
		return null;
	}

	@Override
	public boolean deleteById(int drinkId) {
		boolean deleted = false;
		DirtyDrink drink = drinkRepo.findById(drinkId).orElse(null);
		if (drink != null) {
			
		}
		return deleted;
	}

}
