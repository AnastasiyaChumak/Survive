package com.Diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Diplom.entity.LogUser;
import com.Diplom.entity.User;
import com.Diplom.repositories.UserRepository;
import com.Diplom.services.AnswerService;
import com.Diplom.services.LogUserService;
import com.Diplom.services.QuestionService;
import com.Diplom.services.UserService;

@Controller
public class AccountController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LogUserService logService;

	@GetMapping("/account")
	public String dashboardPageList(Model model, LogUser currentUser) {
		LogUser us = logService.findById(1);
		User user = userService.findByEmail(us.getEmail());
		model.addAttribute("user", user);
		System.out.println(user.getEmail());
		return "views/account";
	}
}
