package com.wipro.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

	Seller findByEmail(String email);

	Optional<Seller> findBySellerName(String name);

	Optional<Seller> findByUsername(String username);

	@Query(value = "SELECT os.order_id FROM order_table o JOIN order_item os ON o.order_id = os.order_id WHERE os.seller_id = :sellerId", nativeQuery = true)
	List<Integer> getOrdersBySellerId(int sellerId);

	@Query(value = "select payment.payment_id from payment where payment_id IN (SELECT payment.payment_id FROM payment JOIN order_table ON payment.payment_id = order_table.payment_id JOIN order_item ON order_table.order_id = order_item.order_id WHERE order_item.seller_id = :sellerId);", nativeQuery = true)
	List<Integer> getPaymentsOfSeller(int sellerId);
}
