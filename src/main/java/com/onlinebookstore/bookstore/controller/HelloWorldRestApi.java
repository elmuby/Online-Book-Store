package com.onlinebookstore.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestApi {
	
	@GetMapping("/hello")
	public String helloWorld(){
		return "<h2>Hello from this side</h2>";
	}
	

}
