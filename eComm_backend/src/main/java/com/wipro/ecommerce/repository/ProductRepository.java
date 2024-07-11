package com.wipro.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByProductName(String name);

	List<Product> findBybrand(String brand);

	List<Product> findBypriceBetween(double min, double max);

	@Query(value = "select * from product where seller_id=?1", nativeQuery = true)
	List<Product> findBySellerId(int sellerId);

	@Query(value = "select * from product where subcategory_id=?1", nativeQuery = true)
	List<Product> findBySubCategoryId(int subcategoryId);
}
