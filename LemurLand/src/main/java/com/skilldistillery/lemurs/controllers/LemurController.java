package com.skilldistillery.lemurs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.lemurs.entities.Lemur;
import com.skilldistillery.lemurs.services.LemurService;

@RequestMapping("api")
@RestController
public class LemurController {
	
	@Autowired
	private LemurService svc;
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("lemurs")
	public List<Lemur> listLemurs() {
		return svc.allLemurs();
	}

}
