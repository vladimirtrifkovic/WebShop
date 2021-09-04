package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
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
	
	@GetMapping("/buyersAdmin")
	public String getBooks(Model model) {
		List<Buyer> buyerList = buyerService.getBuyers();
		model.addAttribute("buyerList", buyerList);
		return "buyers";
	}
	
//	@PostMapping(value="/buyersAdmin/disable")
//	public RedirectView disableBuyer(Buyer buyer, RedirectAttributes redir) {
//		RedirectView  redirectView= new RedirectView("/buyersAdmin",true);
//		
//		Buyer existingBuyer = buyerService.findBuyerById(buyer.getId());
//		if(existingBuyer.isEnabled() == true) {
//			existingBuyer.setEnabled(false);
//		} else {
//			existingBuyer.setEnabled(true);
//		}
//		buyerService.saveBuyer(existingBuyer);
//	    
//	    return redirectView;				
//	}	
	
	@RequestMapping(value = "/buyersAdmin/disable", method = { RequestMethod.POST })
	public String disableBuyer(@RequestParam("buyerId") String buyerId) {
		
		Integer buyerIDI = Integer.parseInt(buyerId);
		Buyer existingBuyer = buyerService.findBuyerById(buyerIDI);
		
		if(existingBuyer.isEnabled() == true) {
			existingBuyer.setEnabled(false);
		} else {
			existingBuyer.setEnabled(true);
		}
		buyerService.saveBuyer(existingBuyer);
		
		
		return "redirect:/buyersAdmin";
	}
	
}
