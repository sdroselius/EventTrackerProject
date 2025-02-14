package com.skilldistillery.dirtysoda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.dirtysoda.entities.DirtyDrinkAddIn;
import com.skilldistillery.dirtysoda.entities.DirtyDrinkAddInId;

import jakarta.transaction.Transactional;

public interface DirtyDrinkAddInRepository extends JpaRepository<DirtyDrinkAddIn, DirtyDrinkAddInId> {
	List<DirtyDrinkAddIn> findByDirtyDrinkId(int drinkId);
	DirtyDrinkAddIn findByDirtyDrinkIdAndAddInId(int drinkId, int addInId);
	boolean existsByDirtyDrinkIdAndAddInId(int drinkId, int addInId);
	@Transactional
	int deleteByDirtyDrinkIdAndAddInId(int drinkId, int addInId);
}
