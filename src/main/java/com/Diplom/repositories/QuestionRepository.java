package com.Diplom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Diplom.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
