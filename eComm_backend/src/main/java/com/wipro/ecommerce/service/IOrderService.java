package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.dto.OrderDTO;
import com.wipro.ecommerce.entity.Order;
import com.wipro.ecommerce.entity.OrderItem;
import com.wipro.ecommerce.exception.OrderNotFoundException;

public interface IOrderService {
	public Order addOrder(OrderDTO orderDTO);
    public Order updateOrder(OrderDTO orderDTO) throws OrderNotFoundException;
    public String deleteOrderById(int orderId) throws OrderNotFoundException;
    public OrderDTO getOrderById(int orderId) throws OrderNotFoundException;
    public List<Order> getAllOrder();

    
  
}
