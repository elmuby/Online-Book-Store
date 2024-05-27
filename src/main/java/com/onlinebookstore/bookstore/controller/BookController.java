package com.onlinebookstore.bookstore.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.bookstore.model.Book;
import com.onlinebookstore.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
	
	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return ResponseEntity.ok(book.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	

}
