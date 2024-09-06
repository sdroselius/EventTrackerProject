package com.skilldistillery.caves.services;

import java.util.List;

import com.skilldistillery.caves.entities.Cave;

public interface CaveService {
	
	List<Cave> getAllCaves();
	Cave showCave(int caveId);
	Cave create(Cave newCave);
	Cave update(int caveId, Cave updatingCave);
	boolean delete(int caveId);

}
