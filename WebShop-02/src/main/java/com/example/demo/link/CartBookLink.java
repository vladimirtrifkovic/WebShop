package com.example.demo.link;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.demo.model.Book;
import com.example.demo.model.Cart;

@Entity
@Table(name = "cartBookLink")
public class CartBookLink implements Serializable {

	private static final long serialVersionUID = 9127249482094327643L;

	@EmbeddedId
	private CartBookLinkId id;
	
	@MapsId("bookId")
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;
	
	@MapsId("cartId")
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	private Integer quantity = 1;

	public CartBookLinkId getId() {
		return id;
	}

	public void setId(CartBookLinkId id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
