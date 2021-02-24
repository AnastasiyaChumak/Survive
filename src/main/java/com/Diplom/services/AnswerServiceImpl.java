package com.Diplom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Diplom.entity.Answer;
import com.Diplom.repositories.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerRepository answerRepository;

	public List<Answer> findAll() {
		return answerRepository.findAll();
	}

	@Override
	public Optional<Answer> findById(String answerId) {
		try {
			Integer id = Integer.valueOf(answerId);
			return answerRepository.findById(id);
		} catch (NumberFormatException e) {
			return Optional.of(new Answer());
		}
	}
	
}
