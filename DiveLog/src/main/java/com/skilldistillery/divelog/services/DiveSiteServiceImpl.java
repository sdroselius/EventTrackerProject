package com.skilldistillery.divelog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.divelog.entities.DiveSite;
import com.skilldistillery.divelog.entities.User;
import com.skilldistillery.divelog.repositories.DestinationRepository;
import com.skilldistillery.divelog.repositories.DiveSiteRepository;
import com.skilldistillery.divelog.repositories.UserRepository;

@Service
public class DiveSiteServiceImpl implements DiveSiteService {

	@Autowired
	private DiveSiteRepository siteRepo;
	
	@Autowired
	private DestinationRepository destRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<DiveSite> allSites() {
		return siteRepo.findAll();
	}

	@Override
	public DiveSite create(String username, DiveSite newSite) {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			return null;
		}
		newSite.setAddedBy(user);
		return siteRepo.saveAndFlush(newSite);
	}

	@Override
	public DiveSite update(int siteId, DiveSite site) {
		DiveSite managedSite = siteRepo.findById(siteId).orElse(null);
		if (managedSite != null) {
			managedSite.setDescription(site.getDescription());
			managedSite.setLatitude(site.getLatitude());
			managedSite.setLongitude(site.getLongitude());
			managedSite.setName(site.getName());
			return siteRepo.saveAndFlush(managedSite);
		}
 		return managedSite;
	}

	@Override
	public DiveSite getSite(int siteId) {
		return siteRepo.findById(siteId).orElse(null);
	}

	@Override
	public List<DiveSite> destinationSites(int destId) {
		if (! destRepo.existsById(destId)) {
			return null;
		}
		return siteRepo.findByDestination_Id(destId);
	}

}
