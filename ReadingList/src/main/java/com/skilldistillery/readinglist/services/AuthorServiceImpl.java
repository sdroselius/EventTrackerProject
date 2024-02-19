package com.skilldistillery.readinglist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.readinglist.entities.Author;
import com.skilldistillery.readinglist.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	
	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	@Override
	public Author create(Author author) {
		return authorRepo.saveAndFlush(author);
	}

}
