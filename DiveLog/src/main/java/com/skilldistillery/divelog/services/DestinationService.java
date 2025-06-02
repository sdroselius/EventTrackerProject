package com.skilldistillery.divelog.services;

import java.util.List;

import com.skilldistillery.divelog.entities.Destination;

public interface DestinationService {
	
	List<Destination> allDestinations();
	Destination get(int destId);
	Destination create(Destination newDestination);
	Destination update(int destId, Destination newDestination);

}
