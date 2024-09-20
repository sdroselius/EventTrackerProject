package com.skilldistillery.caves.services;

import java.util.List;

import com.skilldistillery.caves.entities.CaveVisit;

public interface CaveVisitService {
	
	List<CaveVisit> getUserCaveVisits(int userId);
	List<CaveVisit> getCaveVisits(int caveId);
	CaveVisit create(String username, CaveVisit visit);
	CaveVisit update(String username, int visitId, CaveVisit visit);
	boolean delete(String username, int visitId);

}
