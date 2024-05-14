package com.onlinebookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.bookstore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
