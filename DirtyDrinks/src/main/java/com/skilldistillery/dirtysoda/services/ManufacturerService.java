package com.skilldistillery.dirtysoda.services;

import java.util.List;

import com.skilldistillery.dirtysoda.entities.Manufacturer;

public interface ManufacturerService {
	List<Manufacturer> findAll();
	Manufacturer findById(int manufacturerId);
	Manufacturer create(Manufacturer newManufacturer);
	Manufacturer update(int manufacturerId, Manufacturer manufacturer);
	boolean deleteById(int manufacturerId);
}
