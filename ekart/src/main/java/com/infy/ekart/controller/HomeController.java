package com.infy.ekart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
    	//model.addAttribute("message", environment.getProperty("login.SUCCEESS"));
        return "welcome";
    }

}
