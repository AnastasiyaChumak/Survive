package com.Diplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
	public String showIndexPage() {
		return "views/index";
	}
	
	@GetMapping("/index")
	public String indexPage() {
		return "views/index";
	}
}