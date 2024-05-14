package com.onlinebookstore.bookstore.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	public User() {
		super();
	}
	
	
	public User(Long id, String fullname, String password, String email, List<Order> order, USER_ROLE role,
			List<Book> favorite, List<Address> addresses) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.password = password;
		this.email = email;
		this.order = order;
		this.role = role;
		this.favorite = favorite;
		this.addresses = addresses;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fullname;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> order;
	
	private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;
	
	@ElementCollection
	private List<Book> favorite;
	
	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Address> addresses;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}


	public USER_ROLE getRole() {
		return role;
	}


	public void setRole(USER_ROLE role) {
		this.role = role;
	}


	public List<Book> getFavorite() {
		return favorite;
	}


	public void setFavorite(List<Book> favorite) {
		this.favorite = favorite;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	

}
