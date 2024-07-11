package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.dto.CartDTO;
import com.wipro.ecommerce.entity.Cart;


public interface ICartService {
	 public Cart addCart(CartDTO cartDTO);
     public Cart updateCart(CartDTO cartDTO);
     public String deleteCartById(int cartId);
     public CartDTO getCartbyId(int cartId);
     public List<Cart> getAllCart();
}
