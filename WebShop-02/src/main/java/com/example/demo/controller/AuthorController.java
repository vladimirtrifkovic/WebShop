package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public String getBooks(Model model) {
		List<Author> authorList = authorService.authors();
		model.addAttribute("authors", authorList);
		return "author";
	}
	
	@PostMapping("/authors/addNew")
	public String addAuthor(Author author) {
		authorService.addAuthor(author);
		return "redirect:/authors";
	}
	
	@RequestMapping(value="/authors/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateAuthor(Author author) {
		authorService.addAuthor(author);
		return "redirect:/authors";
	}
	
	@RequestMapping("/authors/findById")
	@ResponseBody
	public Optional<Author> findAuthor(int id) {
		return authorService.findById(id);
	}
	
	@RequestMapping(value="/authors/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteAuthor(int id) {
		authorService.delete(id);
		return "redirect:/authors";
	}
}
