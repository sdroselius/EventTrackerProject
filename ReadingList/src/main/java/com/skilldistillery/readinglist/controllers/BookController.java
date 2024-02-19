package com.skilldistillery.readinglist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.readinglist.entities.Book;
import com.skilldistillery.readinglist.services.AuthorService;
import com.skilldistillery.readinglist.services.BookService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("books")
	public List<Book> index() {
//		List<Book> books = bookService.getAllBooks();
		List<Book> books = bookService.getEnabledBooks();
		return books;
	}
	
	@GetMapping("books/{bookId}")
	public Book showEnabled(@PathVariable("bookId") Integer bookId, HttpServletResponse res) {
		Book book = bookService.getEnabledBook(bookId);
		if (book == null) {
			res.setStatus(404);
		}
		return book;
	}

	@PostMapping("books")
	public Book addBook(@RequestBody Book newBook, HttpServletResponse res, HttpServletRequest req) {
		try {
			newBook = bookService.create(newBook);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(newBook.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			newBook = null;
		}
		return newBook;
	}
	
	@PutMapping("books/{bookId}")
	public Book updateEnabledBook(@PathVariable("bookId") Integer bookId, @RequestBody Book book, HttpServletResponse res) {
		try {
			book = bookService.updateEnabled(bookId, book);
			if (book == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			book = null;
		}
		return book;
	}
	
	@DeleteMapping("books/{bookId}")
	public void deleteBook(@PathVariable Integer bookId, HttpServletResponse res) {
		try {
			if (bookService.deleteById(bookId)) {
				res.setStatus(204);
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
}
