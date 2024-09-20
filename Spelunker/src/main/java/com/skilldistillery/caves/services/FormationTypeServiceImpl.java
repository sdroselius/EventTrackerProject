package com.skilldistillery.caves.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.caves.entities.FormationType;
import com.skilldistillery.caves.repositories.FormationTypeRepository;

@Service
public class FormationTypeServiceImpl implements FormationTypeService {

	@Autowired
	private FormationTypeRepository formationTypeRepo;
	
	@Override
	public List<FormationType> listAllTypes() {
		return formationTypeRepo.findAll();
	}

}
