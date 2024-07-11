package com.wipro.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.dto.CustomerDTO;
import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.entity.Product;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	Optional<Customer> findByUsername(String username);
	Customer findByEmail(String email);

}
