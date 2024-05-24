package com.onlinebookstore.bookstore.config;

import org.springframework.beans.factory.annotation.Value;

public class JwtConstant {
	@Value("${jwt.secret}")
	private String secretKey;

	public String getSecretKey() {
		return secretKey;
	}

	public static final String SECRET_KEY = "dnamlaaxueuqwertyasdfghjklxcvbnmuiopehehejedbadubdhkabhbdkbdakadbfhdb";

	public static final String JWT_HEADER = "Authorization";

}
