package com.onlinebookstore.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.bookstore.model.Book;
import com.onlinebookstore.bookstore.model.User;
import com.onlinebookstore.bookstore.request.CreateBookRequest;
import com.onlinebookstore.bookstore.service.BookService;
import com.onlinebookstore.bookstore.service.UserService;

@RestController  
@RequestMapping("/api/admin")
public class AdminBookController {
	
	private UserService userService;
	private BookService bookService;

	public AdminBookController(BookService bookService, UserService userService) {
		super();
		
		this.userService = userService;
		this.bookService = bookService;
		
	}
	
	@PostMapping("/createBook")
	public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest req,  @RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
//		i
		user.getRole();
		
		Book book = bookService.createBook(req);
		
		
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestHeader("Authorization") String jwt, @RequestBody CreateBookRequest req){
		return null;
	}
	
	@DeleteMapping()
	public void deleteBook(@PathVariable Long id) {
		
	}
	

}
  