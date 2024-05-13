package com.onlinebookstore.bookstore.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String author;
	
	private String Title;
	
	private String Genre;
	
	private String description;
	
	private int quantityInStock;
	
	@Column(length = 1000)
	private List<String> images;

}
