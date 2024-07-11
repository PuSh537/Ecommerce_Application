package com.wipro.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.ecommerce.dto.CartDTO;
import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.service.ICartService;
@SpringBootTest
class CartServiceImpTest {
    @Autowired
	ICartService service;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddCart() {
		CartDTO dto=new CartDTO(2, 500);
		Cart cart=service.addCart(dto);
		assertNotNull(cart);
	}

	@Test
	void testUpdateCart() {
		CartDTO dto=new CartDTO(2, 900);
		Cart cart=service.updateCart(dto);
		assertNotNull(cart);
		
	}

	@Test
	void testDeleteCartById() {
		int id=2;
	     String str1=service.deleteCartById(2);
	     assertNotNull(str1);
	}

	@Test
	void testGetCartbyId() {
		int id=1;
		CartDTO dto=service.getCartbyId(id);
		assertNotNull(dto);
		
	}

	@Test
	void testGetAllCart() {
		List<Cart> list=service.getAllCart();
		assertNotNull(list);
	
	}

}
