package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "book")
public class Book extends Item {

	private static final long serialVersionUID = 7100726528147742920L;

	@ManyToMany(targetEntity = Author.class, cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(
		    name = "bookAuthorLink",
		    joinColumns = @JoinColumn(name = "bookId"),
		    inverseJoinColumns = @JoinColumn(name = "authorId")
		)
	private List<Author> authors = new ArrayList<Author>();
	
	private String publishingHouse;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishDate;
	
	private int pageNumbers;

	
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}
	
	public String getAuthorNames() {
		List<String> authorNames = authors.stream().map(Author::getName).collect(Collectors.toList());
		return String.join(", ", authorNames);
	}
	
}
