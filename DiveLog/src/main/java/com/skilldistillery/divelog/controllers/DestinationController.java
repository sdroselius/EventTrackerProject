package com.skilldistillery.divelog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.divelog.entities.Destination;
import com.skilldistillery.divelog.services.DestinationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class DestinationController {

	@Autowired
	private DestinationService destService;
	
	@GetMapping("destinations")
	public List<Destination> allDestinations() {
		return destService.allDestinations();
	}
	
	@GetMapping("destinations/{destId}")
	public Destination getDestination(@PathVariable("destId") int destId, HttpServletResponse res) {
		Destination dest = destService.get(destId);
		if (dest == null) {
			res.setStatus(res.SC_NOT_FOUND);//404
		}
		return dest;
	}
	
	@PostMapping("destinations")
	public Destination addDestination(
			@RequestBody Destination newDestination,
			HttpServletRequest req,
			HttpServletResponse res
	) {
		try {
			newDestination =  destService.create(newDestination);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(newDestination.getId()).toString() );
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return newDestination;
	}
	

}
