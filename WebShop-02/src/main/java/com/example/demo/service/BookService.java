package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> books(){
		return bookRepository.findAll();
	}
	
	public Book findById(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public void delete(int id) {
		bookRepository.deleteById(id);
	}
}
