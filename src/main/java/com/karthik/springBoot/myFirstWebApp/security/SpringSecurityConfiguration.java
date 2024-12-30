package com.karthik.springBoot.myFirstWebApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
public class SpringSecurityConfiguration {
	
	//LDAP or database  \\ For storing usernames and passwords   , In this we are using inMemoryUserDetails

	// InMemoryUserDetailsManager
	// InMemoryUserDetailsManager(UserDetails... user)
	
	@Bean
	public InMemoryUserDetailsManager storeUserNamePassword() {
		
		Function<String, String> encoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User
                                 .builder()
                                 .passwordEncoder(encoder)
				                 .username("Karthik")
				                 .password("12345")
				                 .roles("USER","ADMIN")
				                 .build();
		
		return new InMemoryUserDetailsManager(userDetails);
	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	


}
