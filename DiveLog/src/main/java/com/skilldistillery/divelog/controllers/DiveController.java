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
import com.skilldistillery.divelog.services.DiveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class DiveController {
	
	private String username = "diverdan";
	
	@Autowired
	private DiveService diveService;

	@GetMapping("dives")
	public List<Dive> index() {
		return diveService.getAllDives();
	}
	
	@GetMapping("dives/{diveId}")
	public Dive show(@PathVariable("diveId") int diveId, HttpServletResponse res) {
		Dive dive = diveService.getDive(diveId);
		if (dive == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return dive;
	}
	
	@PostMapping("divesites/{siteId}/dives")
	public Dive create(@RequestBody Dive newDive, @PathVariable("siteId") int diveSiteId, 
			HttpServletRequest req, HttpServletResponse res) {
		try {
			newDive = diveService.create(username, diveSiteId, newDive);
			res.setStatus(res.SC_CREATED); // 201
			res.setHeader("Location", req.getRequestURL().append("/").append(newDive.getId()).toString());
		} catch (Exception e) {
			res.setStatus(res.SC_BAD_REQUEST); //400
			e.printStackTrace();
		}
		return newDive;
	}
}
