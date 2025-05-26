package com.skilldistillery.divelog.services;

import java.util.List;

import com.skilldistillery.divelog.entities.Dive;

public interface DiveService {
	
	List<Dive> getAllDives();
	List<Dive> getUserDives(String username);
	Dive getDive(int diveId);
	Dive create(String username, int diveSiteId, Dive dive);
	Dive update(String username, int diveId, Dive dive);
	boolean delete(String username, int diveId);

}
