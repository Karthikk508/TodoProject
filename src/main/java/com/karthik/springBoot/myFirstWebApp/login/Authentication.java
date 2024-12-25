package com.karthik.springBoot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class Authentication {
	
	public boolean authenticate(String name,String password) {
		
		boolean validateName = name.equalsIgnoreCase("Santhosh");
		boolean validatePassword = password.equalsIgnoreCase("1234");
		
		return validateName && validatePassword;
	}

}
