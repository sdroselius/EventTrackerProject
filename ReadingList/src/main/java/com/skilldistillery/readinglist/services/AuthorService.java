package com.skilldistillery.readinglist.services;

import java.util.List;

import com.skilldistillery.readinglist.entities.Author;

public interface AuthorService {
	
	List<Author> getAllAuthors();
	Author create(Author author);

}
