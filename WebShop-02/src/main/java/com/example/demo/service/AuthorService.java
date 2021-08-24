package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> authors(){
		return authorRepository.findAll();
	}
	
	public Optional<Author> findById(int id) {
		return authorRepository.findById(id);
	}
	
	public void delete(int id) {
		authorRepository.deleteById(id);
	}
	
	public void addAuthor(Author author) {
		authorRepository.save(author);
	}
}
