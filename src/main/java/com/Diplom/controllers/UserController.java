package com.Diplom.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Diplom.entity.Role;
import com.Diplom.entity.User;
import com.Diplom.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String listUsers(Model model, @RequestParam(defaultValue = "") String name, HttpSession session) {
		model.addAttribute("users", userService.findByNameSearch(name));
		return "views/users";
	}
	
	@PostMapping("/setAdmin")
	public String setUserAdmin(Model model, BindingResult bindingResult, HttpSession session) {
		model.addAttribute("users", userService.findAll());
		String email = (String) session.getAttribute("email");
		User user = userService.findByEmail(email);
		user.setRole(Role.ADMIN);
		return "redirect:/users";

	}

}
