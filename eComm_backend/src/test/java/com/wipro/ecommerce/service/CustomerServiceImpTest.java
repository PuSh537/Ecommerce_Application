package com.wipro.ecommerce.service;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.ecommerce.dto.CustomerDTO;
import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.exception.CustomerNotFoundException;
import com.wipro.ecommerce.service.ICustomerService;
@SpringBootTest
class CustomerServiceImpTest {
	@Autowired
    ICustomerService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddCustomer() {
//    User user = new User(1, "User1", "user1@gmail.com", "User@1", "customer");
//    Cart cart =new Cart(1, 1);
//	CustomerDTO dto =new CustomerDTO(1, "Customer 1","Male", "1234567890", "customer1@gmail.com", user, cart);
//	       Customer dto2 =service.addCustomer(dto);
//	       assertNotNull(dto2);
	}

	@Test
	void testUpdateCustomer() {
//		User user = new User(1, "User1", "user1@gmail.com", "User@1", "customer");
//	    Cart cart =new Cart(1,1);
//		CustomerDTO dto =new CustomerDTO(1, "Customer 1","Female", "1234567899", "customer2@gmail.com", user, cart);
//		       Customer dto2 =service.updateCustomer(dto);
//		       assertNotNull(dto2);
//		
	}

	@Test
	void testDeleteCustomerById() throws CustomerNotFoundException {
		int id=2;
		String s=service.deleteCustomerById(id);
		assertNotNull(s);
	}

	@Test
	void testGetCustomerById() throws CustomerNotFoundException {
		int id=1;
		CustomerDTO dto=service.getCustomerById(id);
		assertNotNull(dto);
	}

	@Test
	void testGetAllCustomer() {
		List<Customer> list=service.getAllCustomer();
		assertNotNull(list);
	}

}
