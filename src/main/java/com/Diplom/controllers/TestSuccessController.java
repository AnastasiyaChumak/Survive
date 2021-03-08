package com.Diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Diplom.entity.LogUser;
import com.Diplom.entity.Result;
import com.Diplom.entity.User;
import com.Diplom.services.LogUserService;
import com.Diplom.services.ResultService;
import com.Diplom.services.UserService;

@Controller
public class TestSuccessController {

	@Autowired
	private ResultService service;

	@Autowired
	private LogUserService logService;

	@Autowired
	private UserService userService;

	@GetMapping("/testSuccess")
	private String getSuccess(Model model) {
		LogUser us = logService.findById(1);
		User user = userService.findByEmail(us.getEmail());
		System.out.println(user.getResult());
		Result resul = service.findByRes(20);
		model.addAttribute("result", resul); 
		return "views/testSuccess";
	}
}
