package com.wipro.ecommerce.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
@Entity
public class OrderItem {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int orderItemId;
	    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	    @JoinColumn(name = "product_id", nullable=true)
	    private Product product;
	    @JsonIgnore
	    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	    @JoinColumn(name = "order_id")
	    private Order order;

	    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	    @JoinColumn(name = "seller_id")
	    private Seller seller;

	    @Positive
	    private int quantity;

	    @Positive
	    private double price;
	    
	    @NotBlank
	    private String status;

	    @NotBlank
	    private String statusDescription;
	    
	    @FutureOrPresent
	    private LocalDate deliveryDate;

		

		public int getOrderItemId() {
			return orderItemId;
		}

		public void setOrderItemId(int orderItemId) {
			this.orderItemId = orderItemId;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public Seller getSeller() {
			return seller;
		}

		public void setSeller(Seller seller) {
			this.seller = seller;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getStatusDescription() {
			return statusDescription;
		}

		public void setStatusDescription(String statusDescription) {
			this.statusDescription = statusDescription;
		}
		

		public LocalDate getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(LocalDate deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		

		public OrderItem(int orderItemId, Product product, Order order, Seller seller, @Positive int quantity,
				@Positive double price, @NotBlank String status, @NotBlank String statusDescription,
				@FutureOrPresent LocalDate deliveryDate) {
			super();
			this.orderItemId = orderItemId;
			this.product = product;
			this.order = order;
			this.seller = seller;
			this.quantity = quantity;
			this.price = price;
			this.status = status;
			this.statusDescription = statusDescription;
			this.deliveryDate = deliveryDate;
		}

		@Override
		public String toString() {
			return "OrderItem [orderItemId=" + orderItemId + ", product=" + product + ", order=" + order + ", seller="
					+ seller + ", quantity=" + quantity + ", price=" + price + ", status=" + status
					+ ", statusDescription=" + statusDescription + ", deliveryDate=" + deliveryDate + "]";
		}

		public OrderItem() {
			super();
		}
	    
	    

}
