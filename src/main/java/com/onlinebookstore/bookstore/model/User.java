package com.onlinebookstore.bookstore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	public User() {
		super();
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fullname;
	
	private String password;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> order;
	
	private USER_ROLE role;
	
	@ElementCollection
	private List<Book> favorite;
	
	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Address> addresses;	

}
