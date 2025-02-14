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

import com.skilldistillery.dirtysoda.entities.DirtyDrinkAddIn;
import com.skilldistillery.dirtysoda.services.DirtyDrinkAddInService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class DirtyDrinkAddInController {
	
	@Autowired
	private DirtyDrinkAddInService drinkAddInService;
	
	@GetMapping("dirtyDrinks/{drinkId}/addIns")
	public List<DirtyDrinkAddIn> listDrinkAddins(
			@PathVariable("drinkId") int drinkId,
			HttpServletResponse res
	) {
		 List<DirtyDrinkAddIn> addIns = drinkAddInService.findByDrinkId(drinkId);
		 if (addIns == null) {
			 res.setStatus(404);
		 }
		 return addIns;
	}
	
	@PostMapping("dirtyDrinks/{drinkId}/addIns/{addInId}")
	public DirtyDrinkAddIn addDrink(
			@PathVariable("drinkId") Integer drinkId,
			@PathVariable("addInId") Integer addInId,
			@RequestBody DirtyDrinkAddIn drinkAddIn,
			HttpServletRequest req,
			HttpServletResponse res
	) {
		try {
			drinkAddIn = drinkAddInService.create(drinkId, addInId, drinkAddIn);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(drinkAddIn.getId()).toString());;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			drinkAddIn = null;
		}
		return drinkAddIn;
	}
	
	@PutMapping("dirtyDrinks/{drinkId}/addIns/{addInId}")
	public DirtyDrinkAddIn updateDrink(
			@PathVariable("drinkId") Integer drinkId,
			@PathVariable("addInId") Integer addInId,
			@RequestBody DirtyDrinkAddIn drinkAddIn,
			HttpServletRequest req,
			HttpServletResponse res
			) {
		try {
			drinkAddIn = drinkAddInService.update(drinkId, addInId, drinkAddIn);
			if (drinkAddIn == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			drinkAddIn = null;
		}
		return drinkAddIn;
	}
	
	@DeleteMapping("dirtyDrinks/{drinkId}/addIns/{addInId}")
	public void deleteDrink(
			@PathVariable("drinkId") Integer drinkId,
			@PathVariable("addInId") Integer addInId,
			HttpServletResponse res
	) {
		try {
			if (drinkAddInService.deleteById(drinkId, addInId)) {
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
