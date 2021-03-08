package com.Diplom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Diplom.entity.Question;
import com.Diplom.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> findAll() {
		return (List<Question>) questionRepository.findAll();
	}

	@Override
	public Question findById(Integer questionId) {
		return questionRepository.findById(questionId).orElse(new Question());
	}

	@Override
	public List<Question> findByWeather(String weather) {
		return questionRepository.findAllByWeather(weather);
	}
	

}
