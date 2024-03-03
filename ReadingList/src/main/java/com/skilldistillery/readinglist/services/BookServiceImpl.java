package com.skilldistillery.readinglist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.readinglist.entities.Author;
import com.skilldistillery.readinglist.entities.Book;
import com.skilldistillery.readinglist.repositories.AuthorRepository;
import com.skilldistillery.readinglist.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private static final int DEFAULT_AUTHOR_ID = 1;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public List<Book> getEnabledBooks() {
		return bookRepo.findByEnabledTrue();
	}
	
	@Override
	public Book getBook(int bookId) {
		Optional<Book> bookOpt = bookRepo.findById(bookId);
		Book book = null;
		if (bookOpt.isPresent()) {
			book = bookOpt.get();
		}
		return book;
	}

	@Override
	public Book getEnabledBook(int bookId) {
		return bookRepo.getByIdAndEnabledTrue(bookId);
	}
	
	@Override
	public Book create(Book book) {
		book.setEnabled(true);
		return bookRepo.saveAndFlush(book);
	}

	@Override
	public Book update(int bookId, Book book) {
		Optional<Book> bookOpt = bookRepo.findById(bookId);
		Book existing = null;
		if (bookOpt.isPresent()) {
			existing = bookOpt.get();
			existing.setDescription(book.getDescription());
			existing.setLastFinished(book.getLastFinished());
			existing.setPages(book.getPages());
			existing.setTitle(book.getTitle());
			bookRepo.saveAndFlush(existing);
		}
		return existing;
	}

	@Override
	public Book updateEnabled(int bookId, Book book) {
		Book existing = bookRepo.getByIdAndEnabledTrue(bookId);
		if (existing != null) {
			existing.setDescription(book.getDescription());
			existing.setLastFinished(book.getLastFinished());
			existing.setPages(book.getPages());
			existing.setTitle(book.getTitle());
			bookRepo.saveAndFlush(existing);
		}
		return existing;
	}
	
	@Override
	public boolean deleteById(int bookId) {
		boolean deleted = false;
		Book book = bookRepo.getByIdAndEnabledTrue(bookId);
		if (book != null) {
			book.setEnabled(false);
			bookRepo.saveAndFlush(book);
			deleted = true;
		}
		return deleted;
	}

	@Override
	public List<Author> addAuthor(int bookId, int authorId) {
		Book book = bookRepo.searchById(bookId);
		Author author = authorRepo.searchById(authorId);
		if (book != null && author != null) {
			book.addAuthor(author);
			return authorRepo.findByBooksId(bookId);
		}
		return null;
	}

	@Override
	public List<Author> removeAuthor(int bookId, int authorId) {
		Book book = bookRepo.searchById(bookId);
		Author author = authorRepo.searchById(authorId);
		if (book != null && author != null) {
			book.removeAuthor(author);
			return authorRepo.findByBooksId(bookId);
		}
		return null;
	}


}
