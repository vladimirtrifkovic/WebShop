package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		List<Book> bookList = bookService.books();
		model.addAttribute("books", bookList);
		List<Author> authorList = authorService.authors();
		model.addAttribute("authorList", authorList);
		return "book";
	}
	
	
	@Secured("ADMIN")
	@PostMapping("/books/addNew")
	public String addBook(Book book) {
		bookService.addBook(book);
		return "redirect:/books";
	}
	
	@RequestMapping("/books/findById")
	@ResponseBody
	public Book findById(int id) {
		return bookService.findById(id);
	}
	
	@RequestMapping(value = "/books/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Book book) {
		bookService.addBook(book);
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		bookService.delete(id);
		return "redirect/books";
	}
	
	
	

}
