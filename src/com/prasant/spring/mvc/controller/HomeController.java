package com.prasant.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static Logger LOGGER = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String showHome(Model model) {
		LOGGER.info("Showing home page.");
		return "home";
	}
	
}
