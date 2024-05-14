package com.onlinebookstore.bookstore.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	public Cart() {
		super();
	}
	
	
	
	public Cart(long id, User customer, Long total, List<CartItem> item) {
		super();
		this.id = id;
		this.customer = customer;
		this.total = total;
		this.item = item;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private User customer;
	
	private Long total;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> item ;

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public User getCustomer() {
		return customer;
	}



	public void setCustomer(User customer) {
		this.customer = customer;
	}



	public Long getTotal() {
		return total;
	}



	public void setTotal(Long total) {
		this.total = total;
	}



	public List<CartItem> getItem() {
		return item;
	}



	public void setItem(List<CartItem> item) {
		this.item = item;
	}
	
	

}
