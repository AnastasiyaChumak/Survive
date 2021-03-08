package com.Diplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutTestController {
	@GetMapping("/aboutTest")
	public String aboutTestPage() {
		return "views/aboutTest";
	}
}
