package com.example.demo.link;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.demo.model.Cart;
import com.example.demo.model.Music;

@Entity
@Table(name = "cartMusicLink")
public class CartMusicLink implements Serializable {

	private static final long serialVersionUID = 3679723619202694977L;

	@EmbeddedId
	private CartMusicLinkId id;
	
	@MapsId("musicId")
	@ManyToOne
	@JoinColumn(name = "musicId")
	private Music music;
	
	@MapsId("cartId")
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	private Integer quantity = -1;

	public CartMusicLinkId getId() {
		return id;
	}

	public void setId(CartMusicLinkId id) {
		this.id = id;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
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
