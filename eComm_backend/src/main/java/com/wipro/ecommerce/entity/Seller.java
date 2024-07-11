package com.wipro.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SequenceGenerators;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Seller {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.AUTO)
   // @SequenceGenerator(name = "address_seq_gen", sequenceName   = "address_seq", initialValue = 201, allocationSize = 1	)
    private int sellerId;        // Primary Key
	@NotBlank
	private String sellerName;
	@NotBlank
	 private String businessName;
	 @Pattern(regexp = "[0-9]{10}")
	 private String phoneNumber;
	 @Email(message = "Invalid email address")
	 @NotBlank(message = "Email cannot be blank")
	 private String email;
	 @NotBlank(message = "Address cannot be blank")
	 private String address;
	 @NotBlank(message = "Selling domain cannot be blank")
	 private String sellingDomain;
	 @NotBlank(message = "Username is required")
		@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores")
		private String username;
	
	 	 private String password;
	 	 private String role;

	@JsonIgnore
	 @OneToMany(cascade=CascadeType.ALL,mappedBy="seller")
	 private List<Product> product=new ArrayList<Product>();
	 
	 
	// @JsonIgnore
	@ManyToMany(mappedBy = "sellers")
    private List<Order> orders = new ArrayList<>();

	public Seller() {
		super();
	
	}

	public Seller(int sellerId, @NotBlank String sellerName, @NotBlank String businessName,
			@Pattern(regexp = "[0-9]{10}") String phoneNumber,
			@Email(message = "Invalid email address") @NotBlank(message = "Email cannot be blank") String email,
			@NotBlank(message = "Address cannot be blank") String address,

			@NotBlank(message = "Selling domain cannot be blank") String sellingDomain,
			@NotBlank(message = "Username is required") @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores") String username,
			String password, String role, List<Product> product,List<Order> orders) {

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
	public List<Order> getOrder() {
		return orders;
	}
	@JsonIgnore
	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", businessName=" + businessName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", sellingDomain="
				+ sellingDomain + ", username=" + username + ", password=" + password + ", role=" + role + ", product="
				+ product + ", orders=" + orders + "]";

	}

	

	

	
}