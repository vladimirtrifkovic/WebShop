package com.example.demo.link;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.demo.model.Cart;
import com.example.demo.model.Video;

@Entity
@Table(name = "cartVideoLink")
public class CartVideoLink implements Serializable {

	private static final long serialVersionUID = -6401769511205303689L;

	@EmbeddedId
	private CartVideoLinkId id;
	
	@MapsId("videoId")
	@ManyToOne
	@JoinColumn(name = "videoId")
	private Video video;
	
	@MapsId("cartId")
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	private Integer quantity = 1;

	public CartVideoLinkId getId() {
		return id;
	}

	public void setId(CartVideoLinkId id) {
		this.id = id;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
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
