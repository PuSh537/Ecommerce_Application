package com.wipro.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.CategoryDTO;
import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.SubCategory;
import com.wipro.ecommerce.exception.CategoryNotFoundException;
import com.wipro.ecommerce.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements ICategoryService {
	@Autowired
	CategoryRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImp.class);

	@Override
	public Category addCategory(CategoryDTO categoryDTO) {
		logger.info("Adding new Category");
		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(category.getCategoryName());
		return repo.save(category);
	}

	@Override
	public Category updateCategory(CategoryDTO categoryDTO) throws CategoryNotFoundException {

		Category category = repo.findById(categoryDTO.getCategoryId()).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("Category with ID " + categoryDTO.getCategoryId() + "not found.");
		}

		logger.info("Updating the Category");
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());

		return repo.save(category);
	}

	@Override
	public String deleteCategoryById(int categoryId) throws CategoryNotFoundException {

		Category category = repo.findById(categoryId).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("Category with ID " + categoryId + "not found.");
		}

		logger.info("Deleting the category with category Id: " + categoryId);

		repo.deleteById(categoryId);

		return "Category Id with categoryId " + categoryId + " deleted.";
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) throws CategoryNotFoundException {

		Category category = repo.findById(categoryId).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("Category with ID " + categoryId + "not found.");
		}
		CategoryDTO dto = new CategoryDTO();
		dto.setCategoryId(category.getCategoryId());
		dto.setCategoryName(category.getCategoryName());

		return dto;
	}

	@Override
	public List<Category> getAllCategory() {
		logger.info("Fetching all categories ...");
		return repo.findAll();
	}

	@Override
	public List<SubCategory> getSubCategoryIdByCategoryId(int categoryId) throws CategoryNotFoundException {
		Category category = repo.findById(categoryId).orElse(null);
		if (category == null) {
			throw new CategoryNotFoundException("Category with ID " + categoryId + "not found.");
		}
		logger.info("Displaying sub categories with categoryId " + categoryId);
		return repo.getSubCategoryIdByCategoryId(categoryId);
	}

	@Override
	public Category getCategorybyName(String name) {
		return repo.findByCategoryName(name).orElse(null);
	}

}
