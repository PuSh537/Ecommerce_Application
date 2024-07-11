package com.wipro.ecommerce.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.Customer;

public class AddressDTO {
		
	    private int addressId;   
	    private String addressLine1;
	    private String addressLine2;
	    private String postalCode;
	    private String city;
	    private String state;
	    private String country;
	    @JsonIgnore
	    private Customer customer;
		
	    public AddressDTO() {
			super();
			
		}
//		public AddressDTO(int addressId, String addressLine1, String addressLine2, String postalCode, String city,
//				String state, String country) {
//			super();
//			this.addressId = addressId;
//			this.addressLine1 = addressLine1;
//			this.addressLine2 = addressLine2;
//			this.postalCode = postalCode;
//			this.city = city;
//			this.state = state;
//			this.country = country;
//		}

		public AddressDTO(int addressId, String addressLine1, String addressLine2, String postalCode, String city,
				String state, String country, Customer customer) {
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
		

		public AddressDTO(int addressId, String addressLine1, String addressLine2, String postalCode, String city, String state,
		String country) {
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



	
		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "AddressDTO [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2="
					+ addressLine2 + ", postalCode=" + postalCode + ", city=" + city + ", state=" + state + ", country="
					+ country +  "]";
		}


		

		
}
