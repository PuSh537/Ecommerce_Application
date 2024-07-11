package com.wipro.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.entity.Product;

public class CartItemDTO {
	
	 private int cartitemId;
	 private int itemQuantity;
	 @JsonIgnore
	 private Product product;
	 @JsonIgnore
	 private Cart cart;

	
	 public CartItemDTO() {
		super();
		
	}

	

	public CartItemDTO(int cartitemId, int itemQuantity, Product product, Cart cart) {
		super();
		this.cartitemId = cartitemId;
		this.itemQuantity = itemQuantity;
		this.product = product;
		this.cart = cart;
	}



	public int getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	

	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}



	@Override
	public String toString() {
		return "CartItemDTO [cartitemId=" + cartitemId + ", itemQuantity=" + itemQuantity + ", product=" + product
				+ ", cart=" + cart + "]";
	}

	

	

}
