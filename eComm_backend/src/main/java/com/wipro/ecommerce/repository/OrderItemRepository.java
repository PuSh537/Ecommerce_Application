package com.wipro.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	@Query(value = "select * from order_item where order_Id = :orderId", nativeQuery = true)
	List<OrderItem> getOrderItemsByOrderId(int orderId);

	@Query(value = "select * from order_item where order_Id = :orderId and seller_id=:sellerId", nativeQuery = true)
	List<OrderItem> viewAllOrderItemsOfSellerInOrder(int orderId, int sellerId);

}
