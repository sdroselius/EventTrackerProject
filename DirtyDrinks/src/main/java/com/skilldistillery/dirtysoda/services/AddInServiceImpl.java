package com.skilldistillery.dirtysoda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dirtysoda.entities.AddIn;
import com.skilldistillery.dirtysoda.repositories.AddInRepository;

@Service
public class AddInServiceImpl implements AddInService {

	@Autowired
	private AddInRepository addInRepo;
	
	@Override
	public List<AddIn> findAll() {
		return addInRepo.findAll();
	}

	@Override
	public AddIn findById(int addInId) {
		return addInRepo.findById(addInId).orElse(null);
	}

	@Override
	public AddIn create(AddIn newAddIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddIn update(int addInId, AddIn addIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int addInId) {
		// TODO Auto-generated method stub
		return false;
	}

}
