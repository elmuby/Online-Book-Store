package com.onlinebookstore.bookstore.service;

import com.onlinebookstore.bookstore.model.User;

public interface UserService {
	
	public User findUserByJwtToken(String jwt) throws Exception;
	
	public User findUserByEmail(String email) throws Exception;

}
