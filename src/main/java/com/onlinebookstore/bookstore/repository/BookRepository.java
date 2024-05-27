package com.onlinebookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	

}
