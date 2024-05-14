package com.onlinebookstore.bookstore.service;

import org.springframework.stereotype.Service;

import com.onlinebookstore.bookstore.config.JwtProvider;
import com.onlinebookstore.bookstore.model.User;
import com.onlinebookstore.bookstore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
		super();
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
	}

	private UserRepository userRepository;
	
	private JwtProvider jwtProvider;

	@Override
	public User findUserByJwtToken(String jwt) throws Exception {
		String email = jwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new Exception("user not found");
		}
		
		return user;
	}

}
