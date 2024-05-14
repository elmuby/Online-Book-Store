package com.onlinebookstore.bookstore.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.bookstore.config.JwtProvider;
import com.onlinebookstore.bookstore.model.Cart;
import com.onlinebookstore.bookstore.model.USER_ROLE;
import com.onlinebookstore.bookstore.model.User;
import com.onlinebookstore.bookstore.repository.CartRepository;
import com.onlinebookstore.bookstore.repository.UserRepository;
import com.onlinebookstore.bookstore.request.LoginRequest;
import com.onlinebookstore.bookstore.response.AuthResponse;
import com.onlinebookstore.bookstore.service.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtProvider jwtProvider;

	private CustomUserDetailsService customUserDetailsService;

	private CartRepository cartRepository;

	public AuthController(UserRepository userRespository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider,
			CustomUserDetailsService customUserDetailsService, CartRepository cartRepository) {
		super();
		this.userRepository = userRespository;
		this.passwordEncoder = passwordEncoder;
		this.jwtProvider = jwtProvider;
		this.customUserDetailsService = customUserDetailsService;
		this.cartRepository = cartRepository;
	}

//	sign up method

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUseHandler(@RequestBody User user) throws Exception {
		User isEmailExist = userRepository.findByEmail(user.getEmail());
		if (isEmailExist != null) {
			throw new Exception("Email is already taken");
		}
		User userCreated = new User();
		userCreated.setEmail(user.getEmail());
		userCreated.setFullname(user.getFullname());
		userCreated.setRole(user.getRole());
		userCreated.setPassword(passwordEncoder.encode(user.getPassword()));

		User savedUser = userRepository.save(userCreated);

		Cart cart = new Cart();
		cart.setCustomer(savedUser);
		cartRepository.save(cart);

		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();

		authResponse.setJwt(jwt);
		authResponse.setMessage("Registration successful");
		authResponse.setRole(savedUser.getRole());
 
		return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest request) {
		String username = request.getEmail();
		String password = request.getPassword();

		Authentication authentication = authenticate(username, password);
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String role = authorities.isEmpty()?null:authorities.iterator().next().getAuthority();

		String jwt = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();

		authResponse.setJwt(jwt);
		authResponse.setMessage("Login successful");
		
		
		
		authResponse.setRole(USER_ROLE.valueOf(role));

		return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

		if (userDetails == null) {
			throw new BadCredentialsException("Invalid username");
		}
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid password");
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}

}
