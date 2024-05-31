package com.onlinebookstore.bookstore.service;

import java.util.List;

import com.onlinebookstore.bookstore.model.Book;
import com.onlinebookstore.bookstore.request.CreateBookRequest;

public interface BookService {
	
	public Book createBook(CreateBookRequest req);
	
	public void deleteBook(Long bookId) throws Exception;
	
	List<Book> getAllBooks();
	
	public List<Book> searchBook (String keyword);
	
	public Book findBookById (Long bookId) throws Exception;
	
	public Book updateAvailabilityStatus (Long bookId) throws Exception ;

}
