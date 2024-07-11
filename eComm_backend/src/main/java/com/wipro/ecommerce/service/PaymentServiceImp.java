package com.wipro.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.PaymentDTO;
import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.repository.PaymentRepository;

@Service
public class PaymentServiceImp implements IPaymentService {
	@Autowired
	PaymentRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImp.class);

	@Override
	public Payment addPayment(PaymentDTO paymentDTO) {
		logger.info("Adding new Payment..");
		Payment payment = new Payment();
		payment.setPaymentId(paymentDTO.getPaymentId());
		payment.setAmount(paymentDTO.getAmount());
		payment.setOrder(paymentDTO.getOrder());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setPaymentStatus(paymentDTO.getPaymentStatus());
		payment.setPaymentMethod(paymentDTO.getPaymentMethod());
		return repo.save(payment);
	}

	@Override
	public Payment updatePayment(PaymentDTO paymentDTO) {
		logger.info("Updating the Payment");
		Payment payment = new Payment();
		payment.setPaymentId(paymentDTO.getPaymentId());
		payment.setAmount(paymentDTO.getAmount());
		payment.setOrder(paymentDTO.getOrder());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setPaymentStatus(paymentDTO.getPaymentStatus());
		payment.setPaymentMethod(paymentDTO.getPaymentMethod());
		return repo.save(payment);
	}

	@Override
	public String deletePaymentById(int paymentId) {
		logger.info("Deleting Payment with PaymentId: " + paymentId);
		repo.deleteById(paymentId);
		return "Payment with paymentId " + paymentId + " deleted";
	}

	@Override
	public PaymentDTO getPaymentById(int paymentId) {
		Payment payment = repo.findById(paymentId).orElse(null);
		if (payment == null) {
			logger.warn("Payment with " + paymentId + " not found.");
			return null;
		}
		PaymentDTO dto = new PaymentDTO();
		dto.setPaymentId(payment.getPaymentId());
		dto.setAmount(payment.getAmount());
		dto.setOrder(payment.getOrder());
		dto.setPaymentDate(payment.getPaymentDate());
		dto.setPaymentStatus(payment.getPaymentStatus());
		dto.setPaymentMethod(payment.getPaymentMethod());

		return dto;
	}

	@Override
	public List<Payment> getAllPayment() {
		logger.info("Fetching all Payments...");
		return repo.findAll();
	}

}
