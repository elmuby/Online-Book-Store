package com.onlinebookstore.bookstore.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		 user requesting /api/admin should have role as Store_Owner and admin
				.authorizeHttpRequests(
						Authorize -> Authorize.requestMatchers("/api/admin/**").hasAnyRole("STORE_OWNER", "ADMIN")
//		user requesting for /api/** should be authenticated
								.requestMatchers("/api/**").authenticated()
//		permit to sign in and sign up pages
								.anyRequest().permitAll())
//		to check if user  has provided jwtToken 
				.addFilterBefore((Filter) new JwtTokenValidator(), BasicAuthenticationFilter.class)
				.csrf((csrf) -> csrf.disable())
				.cors(cors -> cors.configurationSource(corsConfigurationSource()));
		return http.build();
	}
	
	private CorsConfigurationSource corsConfigurationSource() {
		return new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest arg0) {
				CorsConfiguration cfg = new CorsConfiguration();
//				request coming from front end
				cfg.setAllowedOrigins(Arrays.asList("*"));
//				setting allowed methods
				cfg.setAllowedMethods(Collections.singletonList("*"));
//				to allow credentials
				cfg.setAllowCredentials(true);
			
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				
				cfg.setExposedHeaders(Arrays.asList("Authorization"));
				
				cfg.setMaxAge(3600L);
				
				
				return cfg;
			}
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

}
