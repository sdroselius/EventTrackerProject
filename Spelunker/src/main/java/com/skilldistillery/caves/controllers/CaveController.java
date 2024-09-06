package com.skilldistillery.caves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.caves.entities.Cave;
import com.skilldistillery.caves.services.CaveService;

@RestController
@RequestMapping("api")
public class CaveController {
	
	@Autowired
	private CaveService caveService;
	
	@GetMapping("caves")
	public List<Cave> getCaveList() {
		return caveService.getAllCaves();
	}

}
