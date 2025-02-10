package com.skilldistillery.dirtysoda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dirtysoda.entities.Manufacturer;
import com.skilldistillery.dirtysoda.repositories.ManufacturerRepository;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepo;
	
	@Override
	public List<Manufacturer> findAll() {
		return manufacturerRepo.findAll();
	}

	@Override
	public Manufacturer findById(int manufacturerId) {
		return manufacturerRepo.findById(manufacturerId).orElse(null);
	}

	@Override
	public Manufacturer create(Manufacturer newManufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manufacturer update(int manufacturerId, Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int manufacturerId) {
		// TODO Auto-generated method stub
		return false;
	}

}
