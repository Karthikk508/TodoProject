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

	// LDAP or database \\ For storing usernames and passwords , In this we are
	// using inMemoryUserDetails

	// InMemoryUserDetailsManager
	// InMemoryUserDetailsManager(UserDetails... user)

	@Bean
	public InMemoryUserDetailsManager storeUserNamePassword() {

		UserDetails userDetail1 = createUsers("karthik", "12345");
		UserDetails userDetail2 = createUsers("santhosh", "123456");

		return new InMemoryUserDetailsManager(userDetail1, userDetail2);

	}

	
	private UserDetails createUsers(String username, String password) {

		Function<String, String> encoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder()
									  .passwordEncoder(encoder)
									  .username(username)
									  .password(password)
									  .roles("USER", "ADMIN").build();

		return userDetails;

	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
