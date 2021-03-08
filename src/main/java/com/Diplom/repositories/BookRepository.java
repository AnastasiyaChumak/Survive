package com.Diplom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Diplom.entity.Book;
import com.Diplom.entity.User;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByTopicLike(String topic);
}
