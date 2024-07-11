package com.wipro.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.wipro.ecommerce.entity.CartItem;
import com.wipro.ecommerce.entity.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

public class CartDTO {

	 private int cartId;
	
	 private List<CartItem> cartItems= new ArrayList<CartItem>();
	 
	 private double totalPrice;
	 
	 @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	  	private Customer customer;

	
	 public CartDTO() {
		super();
	
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	

	
	public CartDTO(int cartId, double totalPrice) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		
	}
	

	public CartDTO(int cartId, List<CartItem> cartItems, double totalPrice, Customer customer) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", cartItems=" + cartItems + ", totalPrice=" + totalPrice + ", customer="
				+ customer + ", product=]";
	}
	
	
}
