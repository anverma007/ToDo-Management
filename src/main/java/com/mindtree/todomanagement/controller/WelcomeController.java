package com.mindtree.todomanagement.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WelcomeController {

	 @RequestMapping(method = RequestMethod.GET)
	    public String showWelcomePage(ModelMap model) {
	        model.put("name", getLoggedinUserName());
	        System.out.println("-----------------"+model+"-------------------");
	        return "welcome";
	    }

	    private String getLoggedinUserName() {
	        Object principal = SecurityContextHolder.getContext()
	            .getAuthentication().getPrincipal();

	        if (principal instanceof UserDetails) {
	        	System.out.println("------------------------------------");
	            return ((UserDetails) principal).getUsername();
	        }
	        System.out.println("------------------"+principal.toString()+"------------------");
	        return principal.toString();
	    }

	
}
