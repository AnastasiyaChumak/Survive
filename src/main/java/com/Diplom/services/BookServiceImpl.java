package com.Diplom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Diplom.entity.Book;
import com.Diplom.repositories.BookRepository;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repo;

	@Override
	public Book createBook(Book book) {
		Book newBook = new Book();
		newBook.setTopic(book.getTopic());
		newBook.setDescription(book.getDescription());
		newBook.setLink(book.getLink());
		return repo.save(newBook);

	}
	
	public List<Book> findAll() {
		return repo.findAll();
	}
	
	@Override
	public List<Book> findByTopicSearch(String topic) {
		return repo.findByTopicLike("%" + topic + "%");
	}

}
