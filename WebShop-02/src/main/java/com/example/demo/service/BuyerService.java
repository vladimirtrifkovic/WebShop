package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Buyer;
import com.example.demo.repository.BuyerRepository;

@Service
public class BuyerService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private BuyerRepository buyerRepository;

	public List<Buyer> getBuyers() {
		return buyerRepository.findAll();
	}

	public Buyer findBuyerById(Integer id) {
		return buyerRepository.findById(id).get();
	}

	public void deleteBuyer(Integer id) {
		buyerRepository.deleteById(id);
	}

	public void addBuyer(Buyer buyer) {
		buyer.setPassword(encoder.encode(buyer.getPassword()));
		buyerRepository.save(buyer);
	}

	public Buyer findBuyerByEmail(String email) {
		return buyerRepository.findByEmail(email);
	}

}
