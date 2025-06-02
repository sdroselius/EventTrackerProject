package com.skilldistillery.divelog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.divelog.entities.Destination;
import com.skilldistillery.divelog.repositories.CountryRepository;
import com.skilldistillery.divelog.repositories.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationRepository destRepo;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	public List<Destination> allDestinations() {
		return destRepo.findAll();
	}

	@Override
	public Destination create(Destination newDestination) {
		if (newDestination.getCountry() == null) {
			newDestination.setCountry(countryRepo.findById("__").orElse(null));
		}
		return destRepo.saveAndFlush(newDestination);
	}

	@Override
	public Destination update(int destId, Destination newDestination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination get(int destId) {
		return destRepo.findById(destId).orElse(null);
	}

}
