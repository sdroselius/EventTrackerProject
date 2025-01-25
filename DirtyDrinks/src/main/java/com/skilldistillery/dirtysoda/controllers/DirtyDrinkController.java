package com.skilldistillery.dirtysoda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dirtysoda.entities.DirtyDrink;
import com.skilldistillery.dirtysoda.services.DirtyDrinkService;

@RestController
@RequestMapping("api")
public class DirtyDrinkController {
	
	@Autowired
	private DirtyDrinkService drinkService;
	
	@GetMapping("dirtyDrinks")
	public List<DirtyDrink> listDrinks() {
		return drinkService.findAll();
	}
	
	

}
