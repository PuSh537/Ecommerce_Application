package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.dto.PaymentDTO;
import com.wipro.ecommerce.entity.Payment;

public interface IPaymentService {
	public Payment addPayment(PaymentDTO paymentDTO);

	public Payment updatePayment(PaymentDTO paymentDTO);

	public String deletePaymentById(int paymentId);

	public PaymentDTO getPaymentById(int paymentId);

	public List<Payment> getAllPayment();
}
