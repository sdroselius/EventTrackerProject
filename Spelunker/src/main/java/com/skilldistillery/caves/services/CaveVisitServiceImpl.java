package com.skilldistillery.caves.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.caves.entities.CaveVisit;
import com.skilldistillery.caves.repositories.CaveRepository;
import com.skilldistillery.caves.repositories.CaveVisitRepository;
import com.skilldistillery.caves.repositories.UserRepository;

@Service
public class CaveVisitServiceImpl implements CaveVisitService {
	
	@Autowired
	private CaveVisitRepository visitRepo;
	
	@Autowired
	private CaveRepository caveRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<CaveVisit> getCaveVisits(int caveId) {
		if (! caveRepo.existsById(caveId)) {
			return null;
		}
		return visitRepo.findByCave_Id(caveId);	}

	@Override
	public List<CaveVisit> getUserCaveVisits(int userId) {
		if (! userRepo.existsById(userId)) {
			return null;
		}
		return visitRepo.findByUser_Id(userId);
	}

	@Override
	public CaveVisit create(String username, CaveVisit visit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaveVisit update(String username, int visitId, CaveVisit visit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String username, int visitId) {
		// TODO Auto-generated method stub
		return false;
	}

}
