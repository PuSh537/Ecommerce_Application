package com.wipro.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId; 

	@NotBlank
    private String customerName;
	
	@NotBlank
    private String gender;
	
	@NotBlank
    private String contactNumber;
	
    @NotBlank
    @Email
    private String email;
    
    @NotBlank(message = "Username is required")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores")
	private String username;
    
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") 
    private Address address;
    
    private String role;

    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="cartId")
    private Cart cart;

	@OneToMany( mappedBy="customer")
    private List<Order> order= new ArrayList<Order>();


	public Customer() {
		super();
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

	public Customer(int customerId, @NotBlank String customerName, @NotBlank String gender,
			@NotBlank String contactNumber, @NotBlank @Email String email,
			@NotBlank(message = "Username is required") @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores") String username,
			String password, Address address, String role, Cart cart, List<Order> order) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.role = role;
		this.cart = cart;
		this.order = order;
	}

	
	
    
}

