package com.Diplom.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Diplom.dto.BookDto;
import com.Diplom.entity.Book;
import com.Diplom.services.BookService;

@Controller
public class AddBookController {

	@Autowired
	private BookService service;

	@GetMapping("/book")
	public String registerForm(Model model) {

		model.addAttribute("book", new BookDto());
		return "views/book";
	}

	@PostMapping("/book")
	public String addBookPage(@Valid BookDto book, BindingResult bindingResult, Model model) {
		Book newBook = new Book();
		newBook.setDescription(book.getDescription());
		newBook.setTopic(book.getTopic());
		newBook.setLink(book.getLink());
		service.createBook(newBook);
		return "views/index";
	}
	
	
}
