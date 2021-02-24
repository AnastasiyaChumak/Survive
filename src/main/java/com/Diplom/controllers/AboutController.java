package com.Diplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AboutController {
	@GetMapping("/about")
	public String showAboutPage() {
		return "views/about";
	}
	
	@PostMapping("/about")
	public String aboutPage() {
		return "views/about";
	}
}