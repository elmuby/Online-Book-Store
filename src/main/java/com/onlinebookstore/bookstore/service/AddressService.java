package com.onlinebookstore.bookstore.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinebookstore.bookstore.model.Address;
import com.onlinebookstore.bookstore.repository.AddressRepository;

public class AddressService {
	
	private AddressRepository addressRepository;
	
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		return null;
	}

}
