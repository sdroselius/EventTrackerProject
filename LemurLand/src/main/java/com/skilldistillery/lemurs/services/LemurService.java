package com.skilldistillery.lemurs.services;

import java.util.List;

import com.skilldistillery.lemurs.entities.Lemur;

public interface LemurService {
	
	List<Lemur> allLemurs();
	Lemur retrieveLemur(int lemurId);

}
