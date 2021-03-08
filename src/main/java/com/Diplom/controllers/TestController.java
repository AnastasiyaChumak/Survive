package com.Diplom.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Diplom.entity.Answer;
import com.Diplom.entity.LogUser;	
import com.Diplom.entity.Question;
import com.Diplom.entity.User;
import com.Diplom.services.AnswerService;
import com.Diplom.services.LogUserService;
import com.Diplom.services.QuestionService;
import com.Diplom.services.UserService;

@Controller
public class TestController {

	@Autowired
	private UserService userService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private LogUserService logService;

	int result = 0;

	@GetMapping("/test")
	public String listOfQuestion(Model model, @RequestParam("answerId") Optional<String> answerId) {
	//	List<Question> list = questionService.findByWeather("rain");
		List<Question> list = questionService.findAll();
		LogUser us = logService.findById(1);
		User user = userService.findByEmail(us.getEmail());
		user.setResult(0);
		userService.saveUser(user);
		if (answerId.isPresent()) {
			Answer answer = answerService.findById(answerId.get()).orElse(new Answer());
			boolean isTrue = answer.isTrue();
			if (isTrue) {
				result += 20;
			}
			Question nextQuestion = answer.getNextQuestion();
			Set<Answer> nextAnswers = nextQuestion.getAnswers();
			model.addAttribute("question", nextQuestion);
			model.addAttribute("answers", nextAnswers);

			if (nextQuestion.getId() == 1) {
				user.setResult(result);
				result = 0;
				userService.saveUser(user);
				if (user.getResult() > 40) {
					return "views/testSuccess";
				} else if (user.getResult() < 40) {
					return "views/testSuccess";
				}
			}
			return "views/test :: #replacingContent";
		}
		Integer questionId = list.stream().map(x -> x.getId()).sorted().findFirst().get();
		Question question = questionService.findById(questionId);
		Set<Answer> answers = question.getAnswers();
		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		return "views/test";
	}

}
