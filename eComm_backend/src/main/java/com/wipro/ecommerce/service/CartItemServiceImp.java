package com.wipro.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.CartItemDTO;
import com.wipro.ecommerce.entity.CartItem;
import com.wipro.ecommerce.repository.CartItemRepository;

@Service
public class CartItemServiceImp implements ICartItemService {
	@Autowired
	CartItemRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(CartItemServiceImp.class);

	@Override
	public CartItem addCartItem(CartItemDTO cartItemDTO) {

		logger.info("Adding new Cart Item");
		CartItem cartItem = new CartItem();
		cartItem.setCart(cartItemDTO.getCart());
		cartItem.setProduct(cartItemDTO.getProduct());
		cartItem.setCartitemId(cartItemDTO.getCartitemId());
		cartItem.setItemQuantity(cartItemDTO.getItemQuantity());

		return repo.save(cartItem);
	}

	@Override
	public CartItem updateCartItem(CartItemDTO cartItemDTO) {

		logger.info("Updating CartItem");

		CartItem cartItem = new CartItem();
		cartItem.setCart(cartItemDTO.getCart());
		cartItem.setProduct(cartItemDTO.getProduct());
		cartItem.setCartitemId(cartItemDTO.getCartitemId());
		cartItem.setItemQuantity(cartItemDTO.getItemQuantity());

		return repo.save(cartItem);
	}

	@Override
	public String deleteCartItemById(int cartitemId) {
		logger.info("Deleting cart Item with cartitemId: " + cartitemId);
		repo.deleteById(cartitemId);
		return "Cart Item with cartitemId " + cartitemId + "deleted.";
	}

	@Override
	public CartItemDTO getCartItemById(int cartitemId) {
		CartItem cartItem = repo.findById(cartitemId).orElse(null);
		if (cartItem == null) {
			logger.warn("CartItem with ID " + cartitemId + "not found.");
			return null;
		}

		CartItemDTO dto = new CartItemDTO();
		dto.setCart(cartItem.getCart());
		dto.setProduct(cartItem.getProduct());
		dto.setCartitemId(cartItem.getCartitemId());
		dto.setItemQuantity(cartItem.getItemQuantity());

		return dto;
	}

	@Override
	public List<CartItem> getAllCartItem() {
		logger.info("Fetching all cart items...");
		return repo.findAll();
	}

}
