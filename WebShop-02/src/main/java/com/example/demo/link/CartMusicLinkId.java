package com.example.demo.link;

import java.io.Serializable;

public class CartMusicLinkId implements Serializable {

	private static final long serialVersionUID = -1034446563937039277L;
	
	private Integer cartId;
	
	private Integer musicId;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getMusicId() {
		return musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((musicId == null) ? 0 : musicId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartMusicLinkId other = (CartMusicLinkId) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (musicId == null) {
			if (other.musicId != null)
				return false;
		} else if (!musicId.equals(other.musicId))
			return false;
		return true;
	}

}
