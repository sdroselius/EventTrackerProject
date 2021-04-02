package com.skilldistillery.lemurs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.lemurs.entities.Lemur;
import com.skilldistillery.lemurs.repositories.LemurRepository;

@Service
@Transactional
public class LemurServiceImpl implements LemurService {
	
	@Autowired
	private LemurRepository repo;

	@Override
	public List<Lemur> allLemurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lemur retrieveLemur(int lemurId) {
		// TODO Auto-generated method stub
		return null;
	}

}
