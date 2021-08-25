package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Buyer;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.BuyerService;

@Controller
public class BuyerController {
	
	@Autowired
	private BuyerService buyerService;
	
	
	@GetMapping("/buyers")
	public String getBuyers() {
		
		return "buyer";
	}
	
	@PostMapping(value="buyers/addNew")
	public RedirectView addNew(Buyer buyer, RedirectAttributes redir) {
		RedirectView  redirectView= new RedirectView("/login",true);
		
		Buyer existingBuyer = buyerService.findBuyerByEmail(buyer.getEmail());
		if(existingBuyer !=null) {
			redir.addFlashAttribute("message1", "Registration failed! Email already exists!");
		} else {
			buyerService.addBuyer(buyer);
			redir.addFlashAttribute("message", "You successfully registered! You can now login");
		}
	    
	    return redirectView;				
	}	
	
}
