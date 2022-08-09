package com.lukejlackey.springbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lukejlackey.springbooks.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books/{id}")
	public String index(
			@PathVariable("id") Long id,
			Model model
			) {
		model.addAttribute("book", bookService.findBook(id));
		return "show.jsp";
	}
	
}
