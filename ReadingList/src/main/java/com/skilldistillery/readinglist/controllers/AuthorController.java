package com.skilldistillery.readinglist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.readinglist.entities.Author;
import com.skilldistillery.readinglist.services.AuthorService;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("authors")
	public List<Author> getAuthors() {
		return authorService.getAllAuthors();
	}
}
