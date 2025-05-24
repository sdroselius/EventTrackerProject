package com.skilldistillery.divelog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.divelog.entities.Dive;
import com.skilldistillery.divelog.entities.DiveSite;
import com.skilldistillery.divelog.entities.User;
import com.skilldistillery.divelog.repositories.DiveRepository;
import com.skilldistillery.divelog.repositories.DiveSiteRepository;
import com.skilldistillery.divelog.repositories.UserRepository;

@Service
public class DiveServiceImpl implements DiveService {

	@Autowired
	private DiveRepository diveRepo;	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DiveSiteRepository siteRepo;
	
	@Override
	public List<Dive> getAllDives() {
		return diveRepo.findAll();
	}

	@Override
	public Dive getDive(int diveId) {
		return diveRepo.findById(diveId).orElse(null);
	}

	@Override
	public Dive create(String username, int diveSiteId, Dive dive) {
		User user = userRepo.findByUsername(username);
		DiveSite site = siteRepo.findById(diveSiteId).orElse(null);
		if (user != null && site != null) {
			dive.setUser(user);
			dive.setDiveSite(site);
			return diveRepo.saveAndFlush(dive);
		}
		return null;
	}

	@Override
	public Dive update(String username, int diveId, Dive dive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String username, int diveId) {
		// TODO Auto-generated method stub
		return false;
	}

}
