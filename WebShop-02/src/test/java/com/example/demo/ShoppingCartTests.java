package com.example.demo;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ShoppingCartTests {
	
//	@Autowired
//	private CartItemRepository cartRepo;
//	
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	@Test
//	public void testAddOneCartItem() {
//		Book book = entityManager.find(Book.class, 1);
//		Buyer buyer = entityManager.find(Buyer.class, 1);
//		
//		CartItem newItem = new CartItem();
//		newItem.setBuyer(buyer);
//		newItem.setBook(book);
//		newItem.setQuantity(1);
//
//		CartItem saveCartItem = cartRepo.save(newItem);
//		
//		assertTrue(saveCartItem.getId() > 0);
//		
//		
//	}
//	
//	@Test
//	public void testGetCartItemsByBuyer() {
//		Buyer buyer = new Buyer();
//		buyer.setId(1);
//		
//		List<CartItem> cartItems =  cartRepo.findByBuyer(buyer);
//		
//		assertEquals(1,  cartItems.size());
//		
//	}

}
