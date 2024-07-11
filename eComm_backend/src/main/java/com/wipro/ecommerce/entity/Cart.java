package com.wipro.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
public class Cart {
	  	@Id
	  	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private int cartId;
	  	@JsonIgnore
		@OneToOne(mappedBy = "cart", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
	  	private Customer customer;

		@JsonIgnore
		@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "cart", orphanRemoval = true)

	    private List<CartItem> cartItems= new ArrayList<CartItem>();

	    @Min(0)
	    @Column(name="cart_total_price")
	    private double totalPrice;

		
		public Cart() {
			super();
		}

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		
		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
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

	

		@Override
		public String toString() {
			return "Cart [cartId=" + cartId +  ", cartItems=" + cartItems + ", totalPrice="
					+ totalPrice + "]";
		}
		public Cart(@NotNull int cartId,  @Positive double totalPrice) {
			super();
			this.cartId = cartId;
			this.totalPrice = totalPrice;
		}

		
		public Cart(@NotNull int cartId, Customer customer, List<CartItem> cartItems, @Min(0) double totalPrice) {
			super();
			this.cartId = cartId;
			this.customer = customer;
			this.cartItems = cartItems;
			this.totalPrice = totalPrice;
			
		}

		

	    
}
