package com.skilldistillery.dirtysoda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dirtysoda.entities.AddIn;
import com.skilldistillery.dirtysoda.entities.DirtyDrink;
import com.skilldistillery.dirtysoda.entities.DirtyDrinkAddIn;
import com.skilldistillery.dirtysoda.entities.DirtyDrinkAddInId;
import com.skilldistillery.dirtysoda.repositories.AddInRepository;
import com.skilldistillery.dirtysoda.repositories.DirtyDrinkAddInRepository;
import com.skilldistillery.dirtysoda.repositories.DirtyDrinkRepository;

@Service
public class DirtyDrinkAddInServiceImpl implements DirtyDrinkAddInService {

	@Autowired
	private DirtyDrinkAddInRepository dirtyDrinkAddInRepo;
	
	@Autowired
	private DirtyDrinkRepository dirtyDrinkRepo;
	
	@Autowired
	private AddInRepository addInRepo;
	
	@Override
	public List<DirtyDrinkAddIn> findByDrinkId(int drinkId) {
		return dirtyDrinkAddInRepo.findAll();
	}

	@Override
	public DirtyDrinkAddIn findByDrinkIdAndAddInId(int drinkId, int addInId) {
		return dirtyDrinkAddInRepo.findByDirtyDrinkIdAndAddInId(drinkId, addInId);
	}

	@Override
	public DirtyDrinkAddIn create(int drinkId, int addInId, DirtyDrinkAddIn newDrinkAddIn) {
		DirtyDrink drink = dirtyDrinkRepo.findById(drinkId).orElse(null);
		AddIn addIn = addInRepo.findById(addInId).orElse(null);
		if (drink != null && addIn != null) {
			DirtyDrinkAddInId id = new DirtyDrinkAddInId(drinkId, addInId);
			newDrinkAddIn.setId(id);
			newDrinkAddIn.setAddIn(addIn);
			newDrinkAddIn.setDirtyDrink(drink);
			return dirtyDrinkAddInRepo.saveAndFlush(newDrinkAddIn);
		}
		return newDrinkAddIn;
	}

	@Override
	public DirtyDrinkAddIn update(int drinkId, int addInId,  DirtyDrinkAddIn drinkAddIn) {
		DirtyDrinkAddIn managedAddIn = dirtyDrinkAddInRepo.findByDirtyDrinkIdAndAddInId(drinkId, addInId);
		if (managedAddIn != null) {
			managedAddIn.setAmount(drinkAddIn.getAmount());
			managedAddIn.setAmountUnit(drinkAddIn.getAmountUnit());
			if (drinkAddIn.getAddIn() != null) {
				managedAddIn.setAddIn(drinkAddIn.getAddIn());
			}
			dirtyDrinkAddInRepo.saveAndFlush(managedAddIn);
		}
		return managedAddIn;
	}

	@Override
	public boolean deleteById(int drinkId, int addInId) {
		boolean deleted = false;
		System.out.println("++++++ " + drinkId + " " + addInId);
		if (dirtyDrinkAddInRepo.existsByDirtyDrinkIdAndAddInId(drinkId, addInId)) {
			System.out.println("++++++ " + drinkId + " " + addInId);
			dirtyDrinkAddInRepo.deleteByDirtyDrinkIdAndAddInId(drinkId, addInId);
			deleted = true;
		}
		return deleted;
	}

}
