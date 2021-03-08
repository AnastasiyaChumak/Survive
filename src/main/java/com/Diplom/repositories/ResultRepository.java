package com.Diplom.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Diplom.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
	List<Result> findAll();
	
	Result findByRes(Integer res);
 
	
}
