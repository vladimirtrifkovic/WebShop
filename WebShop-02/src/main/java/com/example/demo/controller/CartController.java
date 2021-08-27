package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Buyer;
import com.example.demo.model.Cart;
import com.example.demo.service.BuyerService;
import com.example.demo.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BuyerService buyerService;
	
	
	@GetMapping("/carts")
	public String showCartPage(Model model, @AuthenticationPrincipal Authentication authentication ) {
		Buyer buyer = buyerService.findBuyerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
	    List<Cart> cartList = cartService.findAllCartsByBuyer(buyer);
	    
	    model.addAttribute("cartList", cartList);
		return "cart";
	}
	
	@RequestMapping(value = "/carts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteCart(Integer id, @AuthenticationPrincipal Authentication authentication) {
		Buyer buyer = buyerService.findBuyerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		cartService.deleteCart(id, buyer);
		
		return  "redirect:/carts";
	}
	
	@RequestMapping(value = "/carts/submit", method = { RequestMethod.POST})
	public String submitCart( @AuthenticationPrincipal Authentication authentication) {
		Buyer buyer = buyerService.findBuyerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		Cart openCart = cartService.getOpenCart(buyer);
		openCart.setSubmitted(true);
		openCart.setSubmittedDate(new Date());
		cartService.saveCart(openCart);
	
		return "redirect:/carts";
	}
	
}
