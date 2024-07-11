package com.wipro.ecommerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int paymentId;        // Primary Key
	
	@OneToOne(mappedBy="payment",cascade=CascadeType.ALL)
    private Order order;
	 @PastOrPresent
	private LocalDateTime paymentDate;
	 @Positive
	private double amount;
	@NotBlank
	private String paymentMethod;
	@NotBlank
	private String paymentStatus;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Payment(int paymentId, @PastOrPresent LocalDateTime paymentDate, @Positive double amount,
			@NotBlank String paymentMethod, @NotBlank String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
	}


	public Payment(int paymentId, Order order, @PastOrPresent LocalDateTime paymentDate, @Positive double amount,
			@NotBlank String paymentMethod, @NotBlank String paymentStatus) {
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
		return "Payment [paymentId=" + paymentId + ", order=" + order + ", paymentDate=" + paymentDate + ", amount="
				+ amount + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
}
