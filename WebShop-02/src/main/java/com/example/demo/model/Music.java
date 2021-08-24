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
@Table(name = "music")
public class Music extends Item {

	private static final long serialVersionUID = -1158739816196224329L;
	
	
	@ManyToMany(targetEntity = Author.class, cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(
		    name = "musicAuthorLink",
		    joinColumns = @JoinColumn(name = "musicId"),
		    inverseJoinColumns = @JoinColumn(name = "authorId")
		)
	List<Author> authors = new ArrayList<Author>();
	
	private String publishingHouse;
	
	private int duration;
	
	private int cdNumber;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishDate;

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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCdNumber() {
		return cdNumber;
	}

	public void setCdNumber(int cdNumber) {
		this.cdNumber = cdNumber;
	}

	public String getAuthorNames() {
		List<String> authorNames = authors.stream().map(Author::getName).collect(Collectors.toList());
		return String.join(", ", authorNames);
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
