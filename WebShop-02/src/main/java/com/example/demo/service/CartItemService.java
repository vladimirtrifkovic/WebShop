package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Buyer;
import com.example.demo.model.CartItem;
import com.example.demo.repository.CartItemRepository;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	public List<CartItem> listCartItems(Buyer buyer) {
		return cartItemRepo.findByBuyer(buyer);
	}
	
	public void deleteCartItem(Integer id) {
		cartItemRepo.deleteById(id);
	}
	
	public void addCartItem(CartItem cartItem) {
		cartItemRepo.save(cartItem);
	}
	
	public CartItem findById(Integer id) {
		return cartItemRepo.findById(id).get();
	}

}
