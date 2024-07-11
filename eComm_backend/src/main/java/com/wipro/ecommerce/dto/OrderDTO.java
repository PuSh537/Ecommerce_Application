package com.wipro.ecommerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.entity.OrderItem;
import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.entity.Seller;

public class OrderDTO {
	
	private int orderId; 
	@JsonIgnore
	 private Customer customer;
	    private LocalDate orderDate;
	    private double totalAmount;
	    @JsonIgnore
	    private Payment payment;
	    @JsonIgnore
	    private List<Seller> sellers = new ArrayList<>();
	    private List<OrderItem> orderItems = new ArrayList<>();
		public OrderDTO() {
			super();
			
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public LocalDate getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		
		public Payment getPayment() {
			return payment;
		}
		public void setPayment(Payment payment) {
			this.payment = payment;
		}
		
		
		public List<Seller> getSellers() {
			return sellers;
		}
		public void setSellers(List<Seller> sellers) {
			this.sellers = sellers;
		}
		public List<OrderItem> getOrderItems() {
			return orderItems;
		}
		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}
		@Override
		public String toString() {
			return "OrderDTO [orderId=" + orderId + ", customer=" + customer + ", orderDate=" + orderDate
					+ ", totalAmount=" + totalAmount + ", payment=" + payment + ", sellers=" + sellers + ", orderItems="
					+ orderItems + "]";
		}
		public OrderDTO(int orderId, Customer customer, LocalDate orderDate, double totalAmount, Payment payment,
				List<Seller> sellers, List<OrderItem> orderItems) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.payment = payment;
			this.sellers = sellers;
			this.orderItems = orderItems;
		}
		
		
		
}
