package com.skilldistillery.readinglist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.readinglist.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByEnabledTrue();
	Book getByIdAndEnabledTrue(int bookId);
}
