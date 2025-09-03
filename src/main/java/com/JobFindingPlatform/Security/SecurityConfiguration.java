package com.JobFindingPlatform.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfiguration {
	
	public SecurityFilterChain securirityFilterChain(HttpSecurity http) throws Exception {
		http
	    .csrf(csrf -> csrf.disable())
	    .authorizeHttpRequests(auth -> auth
	        .requestMatchers("/api/auth/**","/api/job_Seekers","/api/recruiters","/api/apllications","/api/admins","/api/notifications").permitAll()
	        .anyRequest().authenticated()
	    );
		return http.build();

	}
	@Bean
	public PasswordEncoder passwordEncode() {
		return new  BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception {
		return config.getAuthenticationManager();
	}
	
}
