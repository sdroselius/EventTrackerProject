package com.skilldistillery.divelog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.divelog.entities.Dive;
import com.skilldistillery.divelog.entities.DiveSite;
import com.skilldistillery.divelog.services.DiveSiteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class DiveSiteController {

	private String username = "diverdan";

	@Autowired
	private DiveSiteService diveSiteService;

	@GetMapping("divesites")
	public List<DiveSite> index() {
		return diveSiteService.allSites();
	}

	@GetMapping("divesites/{siteId}")
	public DiveSite show(@PathVariable("siteId") int siteId, HttpServletResponse res) {
		DiveSite diveSite = diveSiteService.getSite(siteId);
		if (diveSite == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return diveSite;
	}

	@PostMapping("divesites")
	public DiveSite create(@RequestBody DiveSite newDiveSite, HttpServletRequest req, HttpServletResponse res) {
		try {
			newDiveSite = diveSiteService.create(username, newDiveSite);
			if (newDiveSite == null) {
				res.setStatus(res.SC_UNAUTHORIZED);// 401
			} else {
				res.setStatus(res.SC_CREATED); // 201
				res.setHeader("Location", req.getRequestURL().append("/").append(newDiveSite.getId()).toString());
			}
		} catch (Exception e) {
			res.setStatus(res.SC_BAD_REQUEST); // 400
			e.printStackTrace();
		}
		return newDiveSite;
	}

	@GetMapping("destinations/{destId}/divesites")
	public List<DiveSite> destinationSites(@PathVariable("destId") int destId, HttpServletResponse res) {
		List<DiveSite> sites = diveSiteService.destinationSites(destId);
		if (sites == null) {
			res.setStatus(res.SC_NOT_FOUND); //404
		}
		return sites;
	}


}
