package com.onlinebookstore.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.bookstore.repository.BookRepository;

@RestController
@RequestMapping("/api/admin/book")
public class AdminBookController {
	
	private BookRepository bookRepository;

	public AdminBookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	

}
