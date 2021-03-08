package com.Diplom.services;

import java.util.List;
import com.Diplom.entity.Book;
import com.Diplom.entity.User;

public interface BookService {
	public Book createBook(Book book);

	public List<Book> findAll();

	public List<Book> findByTopicSearch(String topic);
}
