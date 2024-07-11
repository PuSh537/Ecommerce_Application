package com.wipro.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.ecommerce.entity.Order;
import com.wipro.ecommerce.service.IOrderService;
@SpringBootTest
class OrderServiceImpTest {

	@Autowired
	IOrderService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	@DisplayName("InsertOrder")
	void testAddOrder() {
       Order order = new Order();
	}

	@Test
	void testUpdateOrder() {
	
	}

	@Test
	void testDeleteOrderById() {

	}

	@Test
	void testGetOrderById() {
		
	}

	@Test
	void testGetAllOrder() {
	
	}

}
