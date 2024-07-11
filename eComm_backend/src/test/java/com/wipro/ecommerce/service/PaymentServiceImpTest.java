package com.wipro.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.ecommerce.dto.PaymentDTO;
import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.service.IPaymentService;
@SpringBootTest
class PaymentServiceImpTest {
	
	@Autowired
	IPaymentService service;

	@Test
	void testAddPayment() {
		//fail("Not yet implemented");
		PaymentDTO paymentdto = new PaymentDTO(101,LocalDateTime.now(),999.99,"Debit card","Success");
		Payment payment = service.addPayment(paymentdto);
		assertEquals(101,payment.getPaymentId());
	}

	@Test
	void testUpdatePayment() {
		//fail("Not yet implemented");
		PaymentDTO paymentdto = new PaymentDTO(102,LocalDateTime.now(),99.99,"Credit card","Success");
		Payment payment = service.addPayment(paymentdto);
		PaymentDTO paymentdto2 = new PaymentDTO(102,LocalDateTime.now(),99.0,"Credit card","Success");
		Payment payment2 = service.updatePayment(paymentdto2);
		assertEquals(99.0,payment2.getAmount());
	}

	@Test
	void testDeletePaymentById() {
		//fail("Not yet implemented");
		PaymentDTO paymentdto = new PaymentDTO(103,LocalDateTime.now(),599.99,"COD","Success");
		Payment payment = service.addPayment(paymentdto);
		String delete = service.deletePaymentById(payment.getPaymentId());
		assertNotEquals(null,delete);
	}

	@Test
	void testGetPaymentById() {
		//fail("Not yet implemented");
		PaymentDTO paymentdto = new PaymentDTO(104,LocalDateTime.now(),599.99,"COD","Success");
		Payment payment = service.addPayment(paymentdto);
		PaymentDTO paymentdto2 = service.getPaymentById(payment.getPaymentId());
		assertEquals(104,paymentdto2.getPaymentId());
		
	}

	@Test
	void testGetAllPayment() {
		//fail("Not yet implemented");
		List list = service.getAllPayment();
		//System.out.println(list);
		int size = list.size();

		assertNotEquals(0,size);
	}

}
