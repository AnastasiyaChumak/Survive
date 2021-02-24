package com.Diplom.services;

import java.util.List;

import com.Diplom.entity.Answer;
import com.Diplom.entity.Question;

public interface QuestionService {
	public List<Question> findAll();

	public Question findById(Integer questionId);
}
