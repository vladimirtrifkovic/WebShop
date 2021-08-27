package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.link.CartBookLink;
import com.example.demo.link.CartMusicLink;
import com.example.demo.link.CartVideoLink;
import com.example.demo.model.Book;
import com.example.demo.model.Buyer;
import com.example.demo.model.Cart;
import com.example.demo.model.Music;
import com.example.demo.model.Video;
import com.example.demo.service.BookService;
import com.example.demo.service.BuyerService;
import com.example.demo.service.CartService;

@Controller
public class DetailsController {

	@Autowired
	private BuyerService buyerService;

	@Autowired
	private CartService cartService;
	
	
	@Autowired
	private BookService bookService;

	@GetMapping("/bookDetails")
	public String bookDetails() {

		return "detalji";
	}

	
	
	@RequestMapping(value = "/cartBookDetails/find", method = { RequestMethod.GET })
	public ModelAndView showTableOfItems(@RequestParam("id") String itemId,
			@AuthenticationPrincipal Authentication authentication) {

		ModelAndView mv = new ModelAndView("detalji");

		Integer cartIDI = Integer.parseInt(itemId);

		Buyer buyer = buyerService.findBuyerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

//		System.out.println("Item za cartBookLink je: " + cartIDI + " buyer je: " + buyer.getFirstName());

		Cart cart = cartService.findCartByIdAndBuyer(cartIDI, buyer);

		List<CartBookLink> newCartBookLink = cart.getBooksLink().stream().collect(Collectors.toList());
		List<CartVideoLink> newCartVideoLink = cart.getVideosLink().stream().collect(Collectors.toList());
		List<CartMusicLink> newCartMusicLink = cart.getMusicsLink().stream().collect(Collectors.toList());
		
		double totalPrice = 0;
		int totalQuantity = 0;
		
		if(newCartBookLink != null) {
		for (CartBookLink cbl : newCartBookLink) {
			totalPrice = totalPrice + (cbl.getBook().getPrice() * cbl.getQuantity());
			totalQuantity = totalQuantity + cbl.getQuantity();
			
		}
		}
		
		if(newCartVideoLink != null) {
		for (CartVideoLink cbl : newCartVideoLink) {
			totalPrice = totalPrice + (cbl.getVideo().getPrice() * cbl.getQuantity());
			totalQuantity = totalQuantity + cbl.getQuantity();
		}
		}
		
		if(newCartMusicLink != null) {
			for (CartMusicLink cbl : newCartMusicLink) {
				totalPrice = totalPrice + (cbl.getMusic().getPrice() * cbl.getQuantity());
				totalQuantity = totalQuantity + cbl.getQuantity();
			}
			}
		
		int totalNumberOfItemsInCart = 0;
		totalNumberOfItemsInCart = newCartBookLink.size() + newCartVideoLink.size() + newCartMusicLink.size();
		
		mv.addObject("totalQuantity", totalQuantity);
		mv.addObject("totalNumberOfItemsInCart", totalNumberOfItemsInCart);
		mv.addObject("totalPrice", totalPrice);
		mv.addObject("newCartBookLink", newCartBookLink);
		mv.addObject("newCartVideoLink", newCartVideoLink);
		mv.addObject("newCartMusicLink", newCartMusicLink);
		mv.addObject("cart", cart);

		return mv;
	}

	/////////////////////////////// BOOK QUANTITY UPDATE//////////////////////////////
	@RequestMapping(value = "/cart/updateQuantity", method = { RequestMethod.POST })
	public String updateBookQuantity(@RequestParam("cartId") String cartId, @RequestParam("bookId") String bookId,
			@RequestParam("quantity") String quantity, @RequestParam("buyerId") String buyerId) {

		Integer bookIDI = Integer.parseInt(bookId);
		Integer cartIDI = Integer.parseInt(cartId);
		Integer quantitiIDI = Integer.parseInt(quantity);
		Integer buyerIDI = Integer.parseInt(buyerId);

		Buyer buyer = buyerService.findBuyerById(buyerIDI);
		System.out.println("Id for cart is: " + cartIDI);
		Cart updatingCart = cartService.findCartByIdAndBuyer(cartIDI, buyer);
		List<Integer> bookIds = updatingCart.getBooksLink().stream().map(CartBookLink::getBook).map(Book::getId)
				.collect(Collectors.toList());

		if (bookIds.contains(bookIDI)) {
			CartBookLink currentBook = updatingCart.getBooksLink().stream()
					.filter(b -> b.getBook().getId().equals(bookIDI)).findFirst().get();
			currentBook.setQuantity(quantitiIDI);
		}

		if(updatingCart.isSubmitted() == false) {
			cartService.saveCart(updatingCart);
			}

		return "redirect:/cartBookDetails/find/?id=" + updatingCart.getId();
	}
	
/////////////////////////////// VIDEO QUANTITY UPDATE //////////////////////////////
	@RequestMapping(value = "/cart/updateVideoQuantity", method = { RequestMethod.POST })
	public String updateVideoQuantity(@RequestParam("cartId") String cartId, @RequestParam("videoId") String videoId,
			@RequestParam("quantity") String quantity, @RequestParam("buyerId") String buyerId) {

		Integer videoIDI = Integer.parseInt(videoId);
		Integer cartIDI = Integer.parseInt(cartId);
		Integer quantitiIDI = Integer.parseInt(quantity);
		Integer buyerIDI = Integer.parseInt(buyerId);

		Buyer buyer = buyerService.findBuyerById(buyerIDI);
//		System.out.println("Id for cart is: " + cartIDI);
		Cart updatingCart = cartService.findCartByIdAndBuyer(cartIDI, buyer);
		List<Integer> videoIds = updatingCart.getVideosLink().stream().map(CartVideoLink::getVideo).map(Video::getId)
				.collect(Collectors.toList());

		if (videoIds.contains(videoIDI)) {
			CartVideoLink currentVideo = updatingCart.getVideosLink().stream()
					.filter(b -> b.getVideo().getId().equals(videoIDI)).findFirst().get();
			currentVideo.setQuantity(quantitiIDI);
		}
		if(updatingCart.isSubmitted() == false) {
			cartService.saveCart(updatingCart);
			}

		return "redirect:/cartBookDetails/find/?id=" + updatingCart.getId();
	}
	
/////////////////////////////// MUSIC QUANTITY UPDATE //////////////////////////////
	@RequestMapping(value = "/cart/updateMusicQuantity", method = { RequestMethod.POST })
	public String updateMusicQuantity(@RequestParam("cartId") String cartId, @RequestParam("musicId") String musicId,
			@RequestParam("quantity") String quantity, @RequestParam("buyerId") String buyerId) {

		Integer musicIDI = Integer.parseInt(musicId);
		Integer cartIDI = Integer.parseInt(cartId);
		Integer quantitiIDI = Integer.parseInt(quantity);
		Integer buyerIDI = Integer.parseInt(buyerId);

		Buyer buyer = buyerService.findBuyerById(buyerIDI);
//		System.out.println("Id for cart is: " + cartIDI);
		Cart updatingCart = cartService.findCartByIdAndBuyer(cartIDI, buyer);
		List<Integer> musicIds = updatingCart.getMusicsLink().stream().map(CartMusicLink::getMusic).map(Music::getId)
				.collect(Collectors.toList());

		if (musicIds.contains(musicIDI)) {
			CartMusicLink currentMusic = updatingCart.getMusicsLink().stream()
					.filter(b -> b.getMusic().getId().equals(musicIDI)).findFirst().get();
			currentMusic.setQuantity(quantitiIDI);
		}
		if(updatingCart.isSubmitted() == false) {
		cartService.saveCart(updatingCart);
		}

		return "redirect:/cartBookDetails/find/?id=" + updatingCart.getId();
	}
	
/////////////////////////////// BOOK DELETE FROM CART //////////////////////////////
	@RequestMapping(value = "/cart/deleteBookFromCart", method = { RequestMethod.POST })
	public String deleteBookFromCart(@RequestParam("cartId") String cartId, @RequestParam("bookId") String bookId,
			 @RequestParam("buyerId") String buyerId) {

		Integer bookIDI = Integer.parseInt(bookId);
		Integer cartIDI = Integer.parseInt(cartId);
		Integer buyerIDI = Integer.parseInt(buyerId);
		
		Buyer buyer = buyerService.findBuyerById(buyerIDI);
		Cart updatingCart = cartService.findCartByIdAndBuyer(cartIDI, buyer);
		
		System.out.println("cart id:" + cartIDI + " , bookIDI: " + bookIDI + ", buyer: " + buyerIDI);

		List<Integer> bookIds = updatingCart.getBooksLink().stream().map(CartBookLink::getBook).map(Book::getId)
				.collect(Collectors.toList());
		if (bookIds.contains(bookIDI)) {
			CartBookLink currentBook = updatingCart.getBooksLink().stream()
					.filter(b -> b.getBook().getId().equals(bookIDI)).findFirst().get();
			updatingCart.getBooksLink().remove(currentBook);
		}

		cartService.saveCart(updatingCart);
		
		if(updatingCart != null) {
		return "redirect:/cartBookDetails/find/?id=" + updatingCart.getId();
		} else {
			return "redirect:/carts";
		}
	}
/////////////////////////////// VIDEO DELETE FROM CART //////////////////////////////
	@RequestMapping(value = "/cart/deleteVideoFromCart", method = { RequestMethod.POST })
	public String deleteVideoFromCart(@RequestParam("cartId") String cartId, @RequestParam("videoId") String videoId,
			 @RequestParam("buyerId") String buyerId) {

		Integer videoIDI = Integer.parseInt(videoId);
		Integer cartIDI = Integer.parseInt(cartId);
		Integer buyerIDI = Integer.parseInt(buyerId);
		
		Buyer buyer = buyerService.findBuyerById(buyerIDI);
		Cart updatingCart = cartService.findCartByIdAndBuyer(cartIDI, buyer);
		
		System.out.println("cart id:" + cartIDI + " , videoIDI: " + videoIDI + ", buyer: " + buyerIDI);

		List<Integer> videoIds = updatingCart.getVideosLink().stream().map(CartVideoLink::getVideo).map(Video::getId)
				.collect(Collectors.toList());
		if (videoIds.contains(videoIDI)) {
			CartVideoLink currentVideo = updatingCart.getVideosLink().stream()
					.filter(b -> b.getVideo().getId().equals(videoIDI)).findFirst().get();
			updatingCart.getBooksLink().remove(currentVideo);
		}

		cartService.saveCart(updatingCart);
		
		if(updatingCart != null) {
		return "redirect:/cartBookDetails/find/?id=" + updatingCart.getId();
		} else {
			return "redirect:/carts";
		}
	}
	
/////////////////////////////// MUSIC DELETE FROM CART //////////////////////////////
	@RequestMapping(value = "/cart/deleteMusicFromCart", method = { RequestMethod.POST })
	public String deleteMusicFromCart(@RequestParam("cartId") String cartId, @RequestParam("musicId") String musicId,
			 @RequestParam("buyerId") String buyerId) {

		Integer musicIDI = Integer.parseInt(musicId);
		Integer cartIDI = Integer.parseInt(cartId);
		Integer buyerIDI = Integer.parseInt(buyerId);
		
		Buyer buyer = buyerService.findBuyerById(buyerIDI);
		Cart updatingCart = cartService.findCartByIdAndBuyer(cartIDI, buyer);
		
		System.out.println("cart id:" + cartIDI + " , musicIDI: " + musicIDI + ", buyer: " + buyerIDI);

		List<Integer> musicIds = updatingCart.getMusicsLink().stream().map(CartMusicLink::getMusic).map(Music::getId)
				.collect(Collectors.toList());
		if (musicIds.contains(musicIDI)) {
			CartMusicLink currentMusic = updatingCart.getMusicsLink().stream()
					.filter(b -> b.getMusic().getId().equals(musicIDI)).findFirst().get();
			updatingCart.getMusicsLink().remove(currentMusic);
		}

		cartService.saveCart(updatingCart);
		
		if(updatingCart != null) {
		return "redirect:/cartBookDetails/find/?id=" + updatingCart.getId();
		} else {
			return "redirect:/carts";
		}
	}
	
}
