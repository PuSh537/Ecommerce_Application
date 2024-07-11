package com.wipro.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.SubCategory;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT sc FROM SubCategory sc JOIN sc.category c WHERE c.categoryId = :categoryId")
	List<SubCategory> getSubCategoryIdByCategoryId(int categoryId);

	Optional<Category> findByCategoryName(String name);

}
