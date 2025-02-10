package com.skilldistillery.dirtysoda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dirtysoda.entities.AddIn;
import com.skilldistillery.dirtysoda.services.AddInService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class AddInController {
	
	@Autowired
	private AddInService addInService;

	@GetMapping("addIns")
	public List<AddIn> index() {
		return addInService.findAll();
	}
	
	@GetMapping("addIns/{addInId}")
	public AddIn get(
			@PathVariable("addInId") int addInId,
			HttpServletResponse res
	) {
		AddIn addIn = addInService.findById(addInId);
		if (addIn == null) {
			res.setStatus(404);
		}
		return addIn;
	}
	
	
	
}
