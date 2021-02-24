package com.Diplom.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Diplom.dto.UserDto;
import com.Diplom.entity.User;
import com.Diplom.services.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

/*	@GetMapping("/register")
	public String registerForm(Model model) {

		model.addAttribute("user", new UserDto());
		return "views/register";
	}
*/
/*	 @PostMapping("/register")
	public String registerUser(@Valid UserDto user, BindingResult bindingResult, Model model) {
		if (!user.getPassword().equals(user.getMatchingPassword())) {
			return "views/register";
		}
		User newUser = new User();
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		userService.createUser(newUser);
		return "views/success";
	} 
*/
}
