package com.skilldistillery.dirtysoda.services;

import java.util.List;

import com.skilldistillery.dirtysoda.entities.AddIn;

public interface AddInService {
	List<AddIn> findAll();
	AddIn findById(int addInId);
	AddIn create(AddIn newAddIn);
	AddIn update(int addInId, AddIn addIn);
	boolean deleteById(int addInId);
}
