package com.wipro.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.OrderDTO;
import com.wipro.ecommerce.entity.Order;
import com.wipro.ecommerce.entity.OrderItem;
import com.wipro.ecommerce.exception.OrderNotFoundException;
import com.wipro.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImp implements IOrderService {
	@Autowired
	OrderRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImp.class);

	@Override
	public Order addOrder(OrderDTO orderDTO) {
		logger.info("Adding new Order");
		Order order = new Order();
		order.setOrderId(orderDTO.getOrderId());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setTotalAmount(orderDTO.getTotalAmount());
		order.setPayment(orderDTO.getPayment());
		order.setCustomer(orderDTO.getCustomer());
		order.setSellers(orderDTO.getSellers());
		order.setOrderItems(orderDTO.getOrderItems());
		return repo.save(order);
	}

	@Override
	public Order updateOrder(OrderDTO orderDTO) throws OrderNotFoundException {
		Order order = repo.findById(orderDTO.getOrderId()).orElse(null);
		if (order == null) {
			throw new OrderNotFoundException("Order with " + orderDTO.getOrderId() + " not found.");
		}
		logger.info("Updating new Order");
		order.setOrderId(orderDTO.getOrderId());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setTotalAmount(orderDTO.getTotalAmount());

		return repo.save(order);
	}

	@Override
	public String deleteOrderById(int orderId) throws OrderNotFoundException {
		Order order = repo.findById(orderId).orElse(null);
		if (order == null) {
			throw new OrderNotFoundException("Order with " + orderId + " not found.");
		}
		logger.info("Deleting Order with orderId: " + orderId);
		repo.deleteById(orderId);
		return "Order with orderId " + orderId + " deleted.";
	}

	@Override
	public OrderDTO getOrderById(int orderId) throws OrderNotFoundException {
		Order order = repo.findById(orderId).orElse(null);
		if (order == null) {
			throw new OrderNotFoundException("Order with " + orderId + " not found.");
		}
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(order.getOrderId());
		dto.setOrderDate(order.getOrderDate());
		dto.setOrderItems(order.getOrderItems());

		return dto;
	}

	@Override
	public List<Order> getAllOrder() {
		logger.info("Fetching all Orders..");
		return repo.findAll();
	}

}
