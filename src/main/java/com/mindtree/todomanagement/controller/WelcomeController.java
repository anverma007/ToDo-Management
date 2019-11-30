package com.mindtree.todomanagement.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WelcomeController {

	 @RequestMapping(value = "/" ,method = RequestMethod.GET)
	    public String showWelcomePage(ModelMap model) {
	        model.put("name", getLoggedinUserName());
	        return "redirect:/list-todos";
	    }

	    private String getLoggedinUserName() {
	        Object principal = SecurityContextHolder.getContext()
	            .getAuthentication().getPrincipal();

	        if (principal instanceof UserDetails) {
	            return ((UserDetails) principal).getUsername();
	        }
	        return principal.toString();
	    }

	
}
