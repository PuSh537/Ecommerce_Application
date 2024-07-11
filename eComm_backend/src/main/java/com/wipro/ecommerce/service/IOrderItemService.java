package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.dto.OrderItemDTO;
import com.wipro.ecommerce.entity.OrderItem;

public interface IOrderItemService {
	public OrderItem addOrderItem(OrderItemDTO orderItemDTO);
	public OrderItem updateOrderItem(OrderItemDTO orderItemDTO);
	public OrderItemDTO getOrderItemById(int orderItemId);
	public List<OrderItem> getAllOrderItems();
	public List<OrderItem> getOrderItemsByOrderId(int orderId);
	public List<OrderItem> viewAllOrderItemsOfSellerInOrder(int orderId,int sellerId);
}
