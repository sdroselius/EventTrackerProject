package com.skilldistillery.dirtysoda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dirtysoda.entities.Manufacturer;
import com.skilldistillery.dirtysoda.services.ManufacturerService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@GetMapping("manufacturers")
	public List<Manufacturer> index() {
		return manufacturerService.findAll();
	}

	@GetMapping("manufacturers/{manId}")
	public Manufacturer get(
			@PathVariable("manId") int manId,
			HttpServletResponse res
	) {
		Manufacturer man =  manufacturerService.findById(manId);
		if (man == null) {
			res.setStatus(404);
		}
		return man;
	}
	
}
