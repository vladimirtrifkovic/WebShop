package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Buyer;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repository.BuyerRepository;

@Service
public class BuyerDetailsService implements UserDetailsService {
	
	

	@Autowired
	private BuyerRepository buyerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Buyer buyer = buyerRepository.findByEmail(email);
		
		if(buyer == null) {
			throw new UsernameNotFoundException("Buyer Not Found!");
		}
		return new UserPrincipal(buyer);
	}

}
