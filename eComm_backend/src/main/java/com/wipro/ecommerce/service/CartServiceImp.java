package com.wipro.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.CartDTO;
import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.repository.CartRepository;

@Service
public class CartServiceImp implements ICartService {
	@Autowired
	CartRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(CartServiceImp.class);

	@Override
	public Cart addCart(CartDTO cartDTO) {
		logger.info("Adding new Cart");
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setCartItems(cartDTO.getCartItems());
		cart.setCustomer(cartDTO.getCustomer());
		cart.setTotalPrice(cartDTO.getTotalPrice());
		return repo.save(cart);
	}

	@Override
	public Cart updateCart(CartDTO cartDTO) {
		logger.info("Updating Cart");
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setCartItems(cartDTO.getCartItems());
		cart.setCustomer(cartDTO.getCustomer());
		cart.setTotalPrice(cartDTO.getTotalPrice());

		return repo.save(cart);
	}

	@Override
	public String deleteCartById(int cartId) {

		logger.info("Deleting cart with cartId: " + cartId);

		repo.deleteById(cartId);

		return "Cart with cartId " + cartId + " deleted.";
	}

	@Override
	public CartDTO getCartbyId(int cartId) {

		Cart cart = repo.findById(cartId).orElse(null);
		if (cart == null) {
			logger.warn("Cart with ID " + cartId + "not found.");
			return null;
		}
		CartDTO dto = new CartDTO();
		dto.setCartId(cart.getCartId());
		dto.setCartItems(cart.getCartItems());
		dto.setCustomer(cart.getCustomer());
		dto.setTotalPrice(cart.getTotalPrice());
		dto.setCartItems(cart.getCartItems());

		return dto;
	}

	@Override
	public List<Cart> getAllCart() {
		logger.info("Fetching all carts ...");
		return repo.findAll();
	}

}
