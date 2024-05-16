package com.onlinebookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.bookstore.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	

}
