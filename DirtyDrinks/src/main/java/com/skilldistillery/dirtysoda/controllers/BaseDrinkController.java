package com.skilldistillery.dirtysoda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dirtysoda.entities.BaseDrink;
import com.skilldistillery.dirtysoda.services.BaseDrinkService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class BaseDrinkController {
	
	@Autowired
	private BaseDrinkService drinkService;
	
	@GetMapping("baseDrinks")
	public List<BaseDrink> listDrinks() {
		return drinkService.findAll();
	}
	
	@GetMapping("baseDrinks/{drinkId}")
	public BaseDrink getDrink(
			@PathVariable("drinkId") Integer drinkId,
			HttpServletResponse res
	) {
		BaseDrink drink = drinkService.findById(drinkId);
		if (drink == null) {
			res.setStatus(404);
		}
		return drink;
	}
	
	@PostMapping("baseDrinks")
	public BaseDrink addDrink(
			@RequestBody BaseDrink drink,
			HttpServletRequest req,
			HttpServletResponse res
	) {
		try {
			drink = drinkService.create(drink);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(drink.getId()).toString());;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			drink = null;
		}
		return drink;
	}
	
	@PutMapping("baseDrinks/{drinkId}")
	public BaseDrink updateDrink(
			@PathVariable("drinkId") Integer drinkId,
			@RequestBody BaseDrink drink,
			HttpServletRequest req,
			HttpServletResponse res
			) {
		try {
			drink = drinkService.update(drinkId, drink);
			if (drink == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			drink = null;
		}
		return drink;
	}
	
	@DeleteMapping("baseDrinks/{drinkId}")
	public void deleteDrink(
			@PathVariable("drinkId") Integer drinkId,
			HttpServletResponse res
	) {
		try {
			if (drinkService.deleteById(drinkId)) {
				res.setStatus(204);
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	

}
