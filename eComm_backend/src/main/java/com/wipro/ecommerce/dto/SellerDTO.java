package com.wipro.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.Order;
import com.wipro.ecommerce.entity.Product;

public class SellerDTO {
	
	 private int sellerId;        // Primary Key
	 private String sellerName;
	 private String businessName;
	
	 private String phoneNumber;
	 
	 private String email;
	 
	 private String address;
	 
	 private String sellingDomain;

		private String username;
	 
	 private String password;
	 
	 private String role;
     @JsonIgnore
	 private List<Product> product=new ArrayList<Product>();
     @JsonIgnore
     private List<Order> orders = new ArrayList<>();
	
	 public SellerDTO() {
		super();
	
	}
	 

	public SellerDTO(int sellerId, String sellerName, String businessName, String phoneNumber, String email,

			String address, String sellingDomain, String username, String password, String role, List<Product> product,
			List<Order> orders) {

		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.businessName = businessName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.sellingDomain = sellingDomain;
		this.username = username;
		this.password = password;
		this.role = role;
		this.product = product;
		this.orders = orders;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSellingDomain() {
		return sellingDomain;
	}


	public void setSellingDomain(String sellingDomain) {
		this.sellingDomain = sellingDomain;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}
	@JsonIgnore
	public List<Order> getOrders() {
		return orders;
	}

	@JsonIgnore
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "SellerDTO [sellerId=" + sellerId + ", sellerName=" + sellerName + ", businessName=" + businessName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", sellingDomain="
				+ sellingDomain + ", username=" + username + ", password=" + password + ", role=" + role + ", product="
				+ product + ", orders=" + orders + "]";
	}


	
	 
	 

	


	

	
}