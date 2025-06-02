package com.skilldistillery.divelog.services;

import java.util.List;

import com.skilldistillery.divelog.entities.DiveSite;

public interface DiveSiteService {
	List<DiveSite> allSites();
	List<DiveSite> destinationSites(int destId);
	DiveSite getSite(int siteId);
	DiveSite create(String username, DiveSite newSite);
	DiveSite update(int siteId, DiveSite newSite);
}
