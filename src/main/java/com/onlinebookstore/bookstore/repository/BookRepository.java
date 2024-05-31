package com.onlinebookstore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlinebookstore.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("SELECT f FROM Book f WHERE f.title LIKE %:keyword")
	List<Book>searchBook(@Param("keyword") String keyword);
	

}
