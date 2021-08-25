package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Buyer;
import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}
	
	public Cart findCartById(Integer id) {
		return cartRepository.findById(id).get();
	}
	
	public void deleteCart(Integer id, Buyer buyer) {
		cartRepository.deleteByIdAndBuyer(id, buyer);
	}
	
	public List<Cart> findAllCartsByBuyer(Buyer buyer) {
		if (buyer == null) {
			return null;
		}

		return cartRepository.findAllByBuyer(buyer);
	}
	
	public Cart findCartByIdAndBuyer(Integer id, Buyer buyer) {
		if (buyer == null) {
			return null;
		}

		return cartRepository.findByIdAndBuyer(id, buyer);
	}
	
	public Cart getOpenCart(Buyer buyer) {
		return  cartRepository.findByBuyerAndSubmitted(buyer, false);
	}
	
	public List<Cart> getCloseCarts(Buyer buyer) {
		return cartRepository.findAllByBuyerAndSubmitted(buyer, true);
	}
	
	public List<Cart> getAllCartsByBuyer(Buyer buyer) {
		return cartRepository.findAllByBuyer(buyer);
	}
	
	public void saveCart(Cart cart) {
		 cartRepository.save(cart);
	}
	
	public Cart findCurrentByBuyer(Buyer buyer) {
		return cartRepository.findByBuyerAndSubmitted(buyer, false);	
	}

}
