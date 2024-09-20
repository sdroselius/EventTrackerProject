package com.skilldistillery.caves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.caves.entities.CaveVisit;
import com.skilldistillery.caves.services.CaveVisitService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class CaveVisitController {
	
	@Autowired
	private CaveVisitService visitService;

	@GetMapping("caves/{caveId}/visits")
	public List<CaveVisit> getForCave(@PathVariable("caveId") Integer caveId, HttpServletResponse res) {
		List<CaveVisit> visits = visitService.getCaveVisits(caveId);
		if (visits == null) {
			res.setStatus(404);
		}
		return visits;
	}
	
	@GetMapping("users/{userId}/visits")
	public List<CaveVisit> getForUser(@PathVariable("userId") Integer userId, HttpServletResponse res) {
		List<CaveVisit> visits = visitService.getUserCaveVisits(userId);
		if (visits == null) {
			res.setStatus(404);
		}
		return visits;
	}
	
}
