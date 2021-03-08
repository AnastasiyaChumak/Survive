package com.Diplom.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Diplom.entity.Question;
import com.Diplom.entity.Role;
import com.Diplom.entity.User;
import com.Diplom.services.AnswerService;
import com.Diplom.services.LogUserService;
import com.Diplom.services.QuestionService;
import com.Diplom.services.UserService;

@Controller
public class SetAdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private LogUserService logService;

	int result = 0;

	

}
