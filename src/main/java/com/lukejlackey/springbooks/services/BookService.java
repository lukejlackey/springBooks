package com.lukejlackey.springbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lukejlackey.springbooks.models.Book;
import com.lukejlackey.springbooks.repositories.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = this.findBook(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		return bookRepo.save(book);
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
