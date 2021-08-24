	package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.link.CartBookLink;
import com.example.demo.link.CartBookLinkId;
import com.example.demo.link.CartMusicLink;
import com.example.demo.link.CartMusicLinkId;
import com.example.demo.link.CartVideoLink;
import com.example.demo.link.CartVideoLinkId;
import com.example.demo.model.Book;
import com.example.demo.model.Buyer;
import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.model.Music;
import com.example.demo.model.Video;
import com.example.demo.service.BookService;
import com.example.demo.service.BuyerService;
import com.example.demo.service.CartItemService;
import com.example.demo.service.CartService;
import com.example.demo.service.MusicService;
import com.example.demo.service.VideoService;

@Controller
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private MusicService musicService;

	
	
	
	///////////////////////////////////// ADD BOOK TO CART /////////////////////////////////
	@GetMapping("/cartItemBooks/addNew/{id}")
	public RedirectView addBook(@PathVariable("id") Integer bookId, @AuthenticationPrincipal Authentication authentication, RedirectAttributes redir) {
		Buyer buyer = buyerService.findBuyerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		

//		Provjeriti da li za usera postoji cart koji je submitted = false 
//		Ako postoji uporediti sa cartId
		
		Cart currentCart = cartService.findCurrentByBuyer(buyer);
		if(currentCart == null) {
			currentCart = new Cart();
			currentCart.setCreatedDate(new Date());
			currentCart.setSubmitted(false);
			currentCart.setBuyer(buyer);
			currentCart.setBooksLink(new ArrayList<>());
			currentCart.setMusicsLink(new ArrayList<>());
			currentCart.setVideosLink(new ArrayList<>());
		}
		
//		Provjeriti da li za taj cart postoji u cartBookLink (booksLink) book sa BookId
//		ako postoji samo radimo setovanje prosledjenog quantitija
//		ako ne postoji dodajemo taj novi book i setujemo quantity
//		
		List<Integer> bookIds = currentCart.getBooksLink().stream().map(CartBookLink::getBook).map(Book::getId).collect(Collectors.toList());
		if(bookIds.contains(bookId)) {
			CartBookLink currentBook = currentCart.getBooksLink().stream().filter(b -> b.getBook().getId().equals(bookId)).findFirst().get(); //quabtity
			currentBook.setQuantity(currentBook.getQuantity() + 1);
		} else {
			CartBookLink newCartBookLink = new CartBookLink();
			newCartBookLink.setBook(bookService.findById(bookId));
			newCartBookLink.setCart(currentCart);
			CartBookLinkId id = new CartBookLinkId();
			id.setBookId(bookId);
			id.setCartId(currentCart.getId());
			newCartBookLink.setId(id); 
			newCartBookLink.setQuantity(1);
			currentCart.getBooksLink().add(newCartBookLink);
		}
		
		cartService.saveCart(currentCart);
		
		
//		List<Integer> bookIds = new ArrayList<>();
//		for(CartBookLink bookLink : currentCart.getBooksLink()) {
//			bookIds.add(bookLink.getBook().getId());
//		}
//
//		if(bookIds.contains(bookId)) {
//			CartBookLink currentBook = null;
//			for(CartBookLink bookLink : currentCart.getBooksLink()) {}
//				if ( bookLink.getBook().getId().equals(bookId) ) {
//					currentBook = bookLink;
//				}
//			}	
//			currentBook.setQuantity(currentBook.getQuantity() + 1);
//		} else {
//			
//		}

		
//		radi se merge cart-a
		
//		CartItem cartItem = new CartItem();
//		Book book = bookService.findById(id);
//		cartItem.setBook(book);
//		cartItem.setBuyer(buyer);
//		cartItemService.addCartItem(cartItem);
		
		RedirectView  redirectView= new RedirectView("/books",true);
	    redir.addFlashAttribute("messageAddBookToCart", "You successfully added book to cart");
	    
	    return redirectView;				
		
//		return "redirect:/books";
	}
	
	
	//////////////////////////////////ADD VIDEO TO CART//////////////////////////
	
	@GetMapping("/cartItemVideos/addNew/{id}")
	public RedirectView addVideo(@PathVariable("id") Integer videoId,  @AuthenticationPrincipal Authentication authentication, RedirectAttributes redir) {
		Buyer buyer = buyerService.findBuyerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		
		Cart currentCart = cartService.findCurrentByBuyer(buyer);
		if(currentCart == null) {
			currentCart = new Cart();
			currentCart.setCreatedDate(new Date());
			currentCart.setSubmitted(false);
			currentCart.setBuyer(buyer);
			currentCart.setBooksLink(new ArrayList<>());
			currentCart.setMusicsLink(new ArrayList<>());
			currentCart.setVideosLink(new ArrayList<>());
		}
		
		List<Integer> videoIds = currentCart.getVideosLink().stream().map(CartVideoLink::getVideo).map(Video::getId).collect(Collectors.toList());
		if(videoIds.contains(videoId)) {
			CartVideoLink currentVideo = currentCart.getVideosLink().stream().filter(b -> b.getVideo().getId().equals(videoId)).findFirst().get(); //quabtity
			currentVideo.setQuantity(currentVideo.getQuantity() + 1);
		} else {
			CartVideoLink newCartVideoLink = new CartVideoLink();
			newCartVideoLink.setVideo(videoService.findVideoById(videoId));
			newCartVideoLink.setCart(currentCart);
			CartVideoLinkId  id = new CartVideoLinkId();
			id.setVideoId(videoId);
			id.setCartId(currentCart.getId());
			newCartVideoLink.setId(id); 
			newCartVideoLink.setQuantity(1);
			currentCart.getVideosLink().add(newCartVideoLink);
		}
		
		cartService.saveCart(currentCart);
		
		RedirectView  redirectView= new RedirectView("/videos",true);
	    redir.addFlashAttribute("messageAddVideoToCart", "You successfully added video to cart");
	    
	    return redirectView;
		
//		return "redirect:/videos";
	}
	
	//////////////////////////////////ADD MUSIC TO CART//////////////////////////
	
	@GetMapping("/cartItemMusic/addNew/{id}")
	public RedirectView addMusic(@PathVariable("id") Integer musicId,  @AuthenticationPrincipal Authentication authentication, RedirectAttributes redir) {
		Buyer buyer = buyerService.findBuyerByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		
		Cart currentCart = cartService.findCurrentByBuyer(buyer);
		if(currentCart == null) {
			currentCart = new Cart();
			currentCart.setCreatedDate(new Date());
			currentCart.setSubmitted(false);
			currentCart.setBuyer(buyer);
			currentCart.setBooksLink(new ArrayList<>());
			currentCart.setMusicsLink(new ArrayList<>());
			currentCart.setVideosLink(new ArrayList<>());
		}
		
		List<Integer> musicIds = currentCart.getMusicsLink().stream().map(CartMusicLink::getMusic).map(Music::getId).collect(Collectors.toList());
		if(musicIds.contains(musicId)) {
			CartMusicLink currentMusic = currentCart.getMusicsLink().stream().filter(b -> b.getMusic().getId().equals(musicId)).findFirst().get(); //quabtity
			currentMusic.setQuantity(currentMusic.getQuantity() + 1);
		} else {
			CartMusicLink newCartMusicLink = new CartMusicLink();
			newCartMusicLink.setMusic(musicService.getMusicById(musicId));
			newCartMusicLink.setCart(currentCart);
			CartMusicLinkId  id = new CartMusicLinkId();
			id.setMusicId(musicId);
			id.setCartId(currentCart.getId());
			newCartMusicLink.setId(id); 
			newCartMusicLink.setQuantity(1);
			currentCart.getMusicsLink().add(newCartMusicLink);
		}
		
		cartService.saveCart(currentCart);
		
		RedirectView  redirectView= new RedirectView("/musics",true);
	    redir.addFlashAttribute("messageAddMusicToCart", "You successfully added music to cart");
	    
	    return redirectView;
		
//		return "redirect:/musics";
	}
	
	//////////////////////////////////CART BOOK UPDATE QUANTITY //////////////////////////
	
	@RequestMapping(value = "/cartItemBooks/updateQuantity", method = { RequestMethod.POST})
	public ModelAndView updateQuantity( @RequestParam("itemId") String itemId, @RequestParam("bookId") String bookId, 
			@RequestParam("quantity") String quantity, @RequestParam("buyerId") String buyerId) {  
			
		
		Integer bookIDI = Integer.parseInt(bookId);
		Integer itemIDI = Integer.parseInt(itemId);
		Integer quantitiIDI = Integer.parseInt(quantity);
		Integer buyerIDI = Integer.parseInt(buyerId);
		
//		Provjeriti da li za usera postoji cart koji je submitted = false 
//		Ako postoji uporediti sa cartId
		
//		Provjeriti da li za taj cart postoji u cartBookLink (booksLink) book sa BookId
//		ako postoji samo radimo setovanje prosledjenog quantitija
//		ako ne postoji dodajemo taj novi book i setujemo quantity
//		
//		radi se merge cart-a
		
		
		
		CartItem newCart = cartItemService.findById(itemIDI);
		newCart.setQuantity(quantitiIDI);
		cartItemService.addCartItem(newCart);
	
		ModelAndView mv = new ModelAndView("redirect:/cartItemBooks");
		mv.addObject("newCart", newCart);
		
		return mv;
	}
	
//	List<Integer> bookIds = currentCart.getBooksLink().stream().map(CartBookLink::getBook).map(Book::getId).collect(Collectors.toList());
//	if(bookIds.contains(bookId)) {
//		CartBookLink currentBook = currentCart.getBooksLink().stream().filter(b -> b.getBook().getId().equals(bookId)).findFirst().get(); 
//		currentBook.setQuantity(quantity); //
//	
//	}
//	
//	cartService.saveCart(currentCart);
}
