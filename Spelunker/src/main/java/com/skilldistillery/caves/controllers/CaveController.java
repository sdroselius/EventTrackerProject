package com.skilldistillery.caves.controllers;

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

import com.skilldistillery.caves.entities.Cave;
import com.skilldistillery.caves.services.CaveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class CaveController {
	
	@Autowired
	private CaveService caveService;
	
	@GetMapping("caves")
	public List<Cave> getCaveList() {
		return caveService.getAllCaves();
	}
	
	@GetMapping("caves/{caveId}")
	public Cave showCave(@PathVariable("caveId") Integer caveId, HttpServletResponse res) {
		Cave cave = caveService.showCave(caveId);
		if (cave == null) {
			res.setStatus(404);
		}
		return cave;
	}
	
	@PostMapping("caves")
	public Cave createCave(@RequestBody Cave newCave, HttpServletRequest req, HttpServletResponse res) {
		try {
			newCave = caveService.create(newCave);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(newCave.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			newCave = null;
		}
		return newCave;
	}
	
	@PutMapping("caves/{caveId}")
	public Cave updateCave(@PathVariable("caveId") Integer caveId, @RequestBody Cave cave, HttpServletResponse res)
	{
		try {
			cave = caveService.update(caveId, cave);
			if (cave == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			cave = null;
		}
		return cave;
	}
	
	@DeleteMapping("caves/{caveId}")
	public void deleteCave(@PathVariable Integer caveId, HttpServletResponse res) {
		try {
			if (caveService.delete(caveId)) {
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
