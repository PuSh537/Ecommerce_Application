package com.wipro.ecommerce.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.Order;
public class PaymentDTO {
	
	 private int paymentId;  
	 private Order order;
	private LocalDateTime paymentDate;
	private double amount;
	private String paymentMethod;
	private String paymentStatus;
	
	public PaymentDTO() {
		super();
		
	}
	public PaymentDTO(int paymentId, LocalDateTime paymentDate, double amount, String paymentMethod,
			String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}



	public PaymentDTO(int paymentId, Order order, LocalDateTime paymentDate, double amount, String paymentMethod,
			String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", order=" + order + ", paymentDate=" + paymentDate + ", amount="
				+ amount + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + "]";
	}

	
}
