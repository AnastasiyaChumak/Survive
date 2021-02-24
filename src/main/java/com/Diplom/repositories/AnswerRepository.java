package com.Diplom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Diplom.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}