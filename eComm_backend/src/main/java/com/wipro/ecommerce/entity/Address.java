package com.wipro.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Address {
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
	   	private int addressId;        
		@NotBlank
	    @Size(max = 255)
	    private String addressLine1;

	    private String addressLine2;
		@NotBlank
	    @Pattern(regexp = "\\d{6}")
	    private String postalCode;
		@NotBlank
	    private String city;
		@NotBlank
	    private String state;
		@NotBlank
	    private String country;
		@JsonIgnore
		@OneToOne(mappedBy = "address")
		private Customer customer;

	    public Address() {
			super();
		}
	    
		public Address(@NotNull int addressId, @NotBlank @Size(max = 255) String addressLine1,
				@Size(max = 255) String addressLine2, @NotBlank @Pattern(regexp = "\\d{6}") String postalCode,
				@NotBlank String city, @NotBlank String state, @NotBlank String country) {
			super();
			this.addressId = addressId;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.postalCode = postalCode;
			this.city = city;
			this.state = state;
			this.country = country;
		}

		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		@Override
		public String toString() {
			return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2="
					+ addressLine2 + ", postalCode=" + postalCode + ", city=" + city + ", state=" + state + ", country="
					+ country + "]";
		}


		public Address(int addressId, @NotBlank @Size(max = 255) String addressLine1, String addressLine2,
				@NotBlank @Pattern(regexp = "\\d{6}") String postalCode, @NotBlank String city, @NotBlank String state,
				@NotBlank String country, Customer customer) {
			super();
			this.addressId = addressId;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.postalCode = postalCode;
			this.city = city;
			this.state = state;
			this.country = country;
			this.customer = customer;
		}

		public Customer getCustomer() {
			return customer;
		}


		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
    

	    
}