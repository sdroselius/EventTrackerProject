package com.skilldistillery.readinglist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.readinglist.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	Author searchById(int id);

}
