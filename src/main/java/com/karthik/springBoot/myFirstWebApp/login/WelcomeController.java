package com.karthik.springBoot.myFirstWebApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	@Autowired
	private Authentication authenticateObj;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		
		model.put("name", "Karthikeyan");
		return "Welcome";
	}
	
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
		
		if(authenticateObj.authenticate(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "Welcome";
		}
		
		model.put("errorMessage", "Invalid credentials ! Please try again.");
		
		return "login";
	}

}





















//Logger 


//private Logger logger = LoggerFactory.getLogger(getClass());

//System.out.println("My name is " + name);  // not recommended for production level applications

		//logger.debug("I am at debug level " + name);
		//logger.info("I am at info level " + name);
	    //logger.warn("I am at warn level " + name);
		