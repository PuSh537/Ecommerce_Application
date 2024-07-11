package com.wipro.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.Address;
import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.entity.Order;



public class CustomerDTO {
	@JsonIgnore
	private int customerId;        // Primary Key
    private String customerName;
    private String gender;
    private String contactNumber;
    private String email;
    private String username;
    private String password;
    private String role;
    private Address address;
    @JsonIgnore
    private Cart cart;
    @JsonIgnore
    private List<Order> order= new ArrayList<Order>();
    
	
    public CustomerDTO() {
		super();
		
	}


	public CustomerDTO(int customerId, String customerName, String gender, String contactNumber, String email,
			String username, String password, String role, Address address, Cart cart, List<Order> order) {

		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.username = username;
		this.password = password;

		this.role = role;
		this.address = address;

		this.cart = cart;
		this.order = order;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}




	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", username=" + username + ", password="
				+ password + ", role=" + role + ", address=" + address + ", cart=" + cart + ", order=" + order
				+ "]";

	}
    

	public CustomerDTO(int customerId, String customerName, String gender, String contactNumber, String email,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName=customerName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}


	
}
