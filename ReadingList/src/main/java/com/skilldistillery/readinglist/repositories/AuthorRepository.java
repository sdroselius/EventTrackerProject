package com.skilldistillery.readinglist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.readinglist.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	Author searchById(int id);
	List<Author> findByBooksId(int bookId);
}
