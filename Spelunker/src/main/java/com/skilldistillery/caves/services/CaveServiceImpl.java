package com.skilldistillery.caves.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.caves.entities.Cave;
import com.skilldistillery.caves.repositories.CaveRepository;

@Service
public class CaveServiceImpl implements CaveService {
	
	@Autowired
	private CaveRepository caveRepo;

	@Override
	public List<Cave> getAllCaves() {
		return caveRepo.findAll();
	}

	@Override
	public Cave showCave(int caveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cave create(Cave newCave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cave update(int caveId, Cave updatingCave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int caveId) {
		// TODO Auto-generated method stub
		return false;
	}

}
