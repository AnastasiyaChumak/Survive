package com.Diplom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Diplom.entity.Result;
import com.Diplom.repositories.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepository repo;

	@Override
	public List<Result> findAll() {
		return repo.findAll();
	}

	@Override
	public Result findByRes(Integer res) {
		return repo.findByRes(res);
	}
}
