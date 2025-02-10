package com.skilldistillery.dirtysoda.services;

import java.util.List;

import com.skilldistillery.dirtysoda.entities.DirtyDrinkAddIn;
import com.skilldistillery.dirtysoda.entities.DirtyDrinkAddInId;

public interface DirtyDrinkAddInService {
	List<DirtyDrinkAddIn> findByDrinkId(int drinkId);
	DirtyDrinkAddIn findByDrinkIdAndAddInId(int drinkId, int addInId);
	DirtyDrinkAddIn create(int drinkId, int addInId, DirtyDrinkAddIn newDrinkAddIn);
	DirtyDrinkAddIn update(int drinkId, int addInId,  DirtyDrinkAddIn drinkAddIn);
	boolean deleteById(int drinkId, int addInId);

}
