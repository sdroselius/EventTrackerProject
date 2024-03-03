package com.skilldistillery.readinglist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.readinglist.entities.Author;
import com.skilldistillery.readinglist.services.AuthorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("authors")
	public List<Author> getAuthors() {
		return authorService.getAllAuthors();
	}
	
	@PostMapping("authors")
	public Author AddAuthor(@RequestBody Author newAuthor, HttpServletResponse res, HttpServletRequest req) {
		try {
			newAuthor = authorService.create(newAuthor);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(newAuthor.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			newAuthor = null;
		}
		return newAuthor;
	}
}
