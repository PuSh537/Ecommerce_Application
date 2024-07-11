package com.wipro.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.OrderItemDTO;
import com.wipro.ecommerce.entity.OrderItem;
import com.wipro.ecommerce.repository.OrderItemRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderItemServiceImp implements IOrderItemService {

	@Autowired
	OrderItemRepository repo;

	@Override
	public OrderItem addOrderItem(OrderItemDTO orderItemDTO) {

		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(orderItemDTO.getOrderItemId());
//		orderItem.setProduct(orderItemDTO.getProduct());
		orderItem.setDeliveryDate(orderItemDTO.getDeliveryDate());
//		orderItem.setOrder(orderItemDTO.getOrder());
		orderItem.setPrice(orderItemDTO.getPrice());
		orderItem.setQuantity(orderItemDTO.getQuantity());
//		orderItem.setSeller(orderItemDTO.getSeller());
		orderItem.setStatus(orderItemDTO.getStatus());
		orderItem.setStatusDescription(orderItemDTO.getStatusDescription());

		return repo.save(orderItem);
	}

	@Override
	public OrderItemDTO getOrderItemById(int orderItemId) {

		OrderItem orderItem = repo.findById(orderItemId).orElse(null);

		OrderItemDTO dto = new OrderItemDTO();
//		dto.setProduct(orderItem.getProduct());
		dto.setDeliveryDate(orderItem.getDeliveryDate());
//		dto.setOrder(orderItem.getOrder());
		dto.setOrderItemId(orderItem.getOrderItemId());
		dto.setPrice(orderItem.getPrice());
		dto.setQuantity(orderItem.getQuantity());
//		dto.setSeller(orderItem.getSeller());
		dto.setStatus(orderItem.getStatus());
		dto.setStatusDescription(orderItem.getStatusDescription());

		return dto;
	}

	@Override
	public List<OrderItem> getAllOrderItems() {

		return repo.findAll();
	}

	@Override
	public OrderItem updateOrderItem(OrderItemDTO orderItemDTO) {

		OrderItem orderItem = repo.findById(orderItemDTO.getOrderItemId())
				.orElseThrow(() -> new RuntimeException("OrderItem not found"));

		orderItem.setDeliveryDate(orderItemDTO.getDeliveryDate());
		orderItem.setStatus(orderItemDTO.getStatus());
		orderItem.setStatusDescription(orderItemDTO.getStatusDescription());
		return repo.save(orderItem);
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return repo.getOrderItemsByOrderId(orderId);
	}

	@Override
	public List<OrderItem> viewAllOrderItemsOfSellerInOrder(int orderId, int sellerId) {
		return repo.viewAllOrderItemsOfSellerInOrder(orderId, sellerId);
	}

}
