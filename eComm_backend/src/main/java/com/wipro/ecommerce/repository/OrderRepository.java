package com.wipro.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query(value = "select * from order_Table where customer_id=:customerId", nativeQuery = true)
	List<Order> findOrderByCustomerId(int customerId);

}
