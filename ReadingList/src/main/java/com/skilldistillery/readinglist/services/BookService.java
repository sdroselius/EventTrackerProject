package com.skilldistillery.readinglist.services;

import java.util.List;

import com.skilldistillery.readinglist.entities.Book;

public interface BookService {
	
	List<Book> getAllBooks();
	List<Book> getEnabledBooks();
	Book getBook(int bookId);
	Book getEnabledBook(int bookId);
	Book create(Book book);
	Book update(int bookId, Book book);
	Book updateEnabled(int bookId, Book book);
	boolean deleteById(int bookId);

}
