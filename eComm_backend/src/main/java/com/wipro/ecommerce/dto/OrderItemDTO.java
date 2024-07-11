package com.wipro.ecommerce.dto;

import java.time.LocalDate;

public class OrderItemDTO {

	 private int orderItemId;
	    private int productId;
	    private int orderId;
	    private int sellerId;
	    private int quantity;
	    private double price;
	    private String status;
	    private String statusDescription;
	    private LocalDate deliveryDate;
	    
	    
		public int getOrderItemId() {
			return orderItemId;
		}
		public void setOrderItemId(int orderItemId) {
			this.orderItemId = orderItemId;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getSellerId() {
			return sellerId;
		}
		public void setSellerId(int sellerId) {
			this.sellerId = sellerId;
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
		@Override
		public String toString() {
			return "OrderItemDTO [orderItemId=" + orderItemId + ", productId=" + productId + ", orderId=" + orderId
					+ ", sellerId=" + sellerId + ", quantity=" + quantity + ", price=" + price + ", status=" + status
					+ ", statusDescription=" + statusDescription + ", deliveryDate=" + deliveryDate + "]";
		}

	
}
