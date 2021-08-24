package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Buyer;
import com.example.demo.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public Cart findByIdAndBuyer(Integer id, Buyer buyer);

	public List<Cart> findAllByBuyer(Buyer buyer);
	
	public Cart findByBuyerAndSubmitted(Buyer buyer, Boolean submitted);
	
	public List<Cart> findAllByBuyerAndSubmitted(Buyer buyer, Boolean submitted);
	
	public void deleteByIdAndBuyer(Integer id, Buyer buyer);


}