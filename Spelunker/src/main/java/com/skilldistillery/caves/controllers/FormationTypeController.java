package com.skilldistillery.caves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.caves.entities.FormationType;
import com.skilldistillery.caves.services.FormationTypeService;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class FormationTypeController {
	
	@Autowired
	private FormationTypeService formationTypeService;
	
	@GetMapping("formationTypes")
	public List<FormationType> index() {
		return formationTypeService.listAllTypes();
	}

}
