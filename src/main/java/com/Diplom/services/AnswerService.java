package com.Diplom.services;

import java.util.List;
import java.util.Optional;

import com.Diplom.entity.Answer;

public interface AnswerService {
	public List<Answer> findAll();
	
	public Optional<Answer> findById(String answerId);
	 
}
