package com.example.demo.link;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(BookAuthorLinkId.class)
@Table(name = "bookAuthorLink")
public class BookAuthorLink implements Serializable {
	
	private static final long serialVersionUID = -6731702769030802240L;

	@Id
	private Integer bookId;
	
	@Id
	private Integer authorId;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}
