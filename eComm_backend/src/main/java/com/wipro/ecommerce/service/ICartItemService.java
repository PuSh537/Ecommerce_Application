package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.dto.CartItemDTO;
import com.wipro.ecommerce.entity.CartItem;

public interface ICartItemService {
      public CartItem addCartItem(CartItemDTO cartItemDTO);
      public CartItem updateCartItem(CartItemDTO cartItemDTO);
      public String deleteCartItemById(int cartitemId);
      public CartItemDTO getCartItemById(int cartitemId);
      public List<CartItem> getAllCartItem();
}
