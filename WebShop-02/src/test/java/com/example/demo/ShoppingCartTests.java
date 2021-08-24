package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.mapping.PrimaryKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.model.Book;
import com.example.demo.model.Buyer;
import com.example.demo.model.CartItem;
import com.example.demo.repository.CartItemRepository;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ShoppingCartTests {
	
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAddOneCartItem() {
		Book book = entityManager.find(Book.class, 1);
		Buyer buyer = entityManager.find(Buyer.class, 1);
		
		CartItem newItem = new CartItem();
		newItem.setBuyer(buyer);
		newItem.setBook(book);
		newItem.setQuantity(1);

		CartItem saveCartItem = cartRepo.save(newItem);
		
		assertTrue(saveCartItem.getId() > 0);
		
		
	}
	
	@Test
	public void testGetCartItemsByBuyer() {
		Buyer buyer = new Buyer();
		buyer.setId(1);
		
		List<CartItem> cartItems =  cartRepo.findByBuyer(buyer);
		
		assertEquals(1,  cartItems.size());
		
	}

}
