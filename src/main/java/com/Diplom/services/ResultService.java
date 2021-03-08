package com.Diplom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Diplom.entity.Result;

public interface ResultService {

	public List<Result> findAll();

	public Result findByRes(Integer res);
}
