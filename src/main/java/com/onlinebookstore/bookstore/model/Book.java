package com.onlinebookstore.bookstore.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String author;
	
	private String Title;
	 
	private String Genre;
	
	private String description;
	
	private int quantityInStock;
	
	private Long price;
	
	private boolean available;
	
	@Column(length = 1000)
	@ElementCollection
	private List<String> images;
	
	private Date dateAdded;

}
