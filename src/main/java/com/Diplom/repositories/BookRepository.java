package com.Diplom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Diplom.entity.Book;
import com.Diplom.entity.User;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
