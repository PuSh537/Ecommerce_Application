package com.wipro.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.SubCategoryDTO;
import com.wipro.ecommerce.entity.SubCategory;
import com.wipro.ecommerce.exception.SubCategoryNotFoundException;
import com.wipro.ecommerce.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceImp implements ISubCategoryService {
	@Autowired
	SubCategoryRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(SubCategoryServiceImp.class);

	@Override
	public SubCategory addSubCategory(SubCategoryDTO subCategoryDTO) {
		logger.info("Adding new Sub Category...");
		SubCategory subcategory = new SubCategory();
		subcategory.setSubCategoryId(subCategoryDTO.getSubCategoryId());
		subcategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
		subcategory.setCategory(subCategoryDTO.getCategory());
		subcategory.setProducts(subCategoryDTO.getProducts());
		return repo.save(subcategory);
	}

	@Override
	public SubCategory updateSubCategory(SubCategoryDTO subCategoryDTO) throws SubCategoryNotFoundException {
		SubCategory subCategory = repo.findById(subCategoryDTO.getSubCategoryId()).orElse(null);
		if (subCategory == null) {
			throw new SubCategoryNotFoundException(
					"Sub Category with subCategoryId: " + subCategoryDTO.getSubCategoryId() + " not found.");
		}
		logger.info("Updating Sub Category...");
		subCategory.setSubCategoryId(subCategoryDTO.getSubCategoryId());
		subCategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
		subCategory.setCategory(subCategoryDTO.getCategory());
		subCategory.setProducts(subCategoryDTO.getProducts());
		return repo.save(subCategory);
	}

	@Override
	public String deleteSubCategoryById(int subCategoryId) throws SubCategoryNotFoundException {
		SubCategory subCategory = repo.findById(subCategoryId).orElse(null);
		if (subCategory == null) {
			throw new SubCategoryNotFoundException("Sub Category with subCategoryId: " + subCategoryId + " not found.");
		}
		logger.info("Deleting Sub Category with subCategoryId " + subCategoryId);
		repo.deleteById(subCategoryId);
		return "Subcategory  with subcategoryID " + subCategoryId + " deleted.";
	}

	@Override
	public SubCategoryDTO getSubCategoryById(int subCategoryId) throws SubCategoryNotFoundException {
		SubCategory subCategory = repo.findById(subCategoryId).orElse(null);
		if (subCategory == null) {
			throw new SubCategoryNotFoundException("Sub Category with subCategoryId: " + subCategoryId + " not found.");
		}
		SubCategoryDTO dto = new SubCategoryDTO();
		dto.setSubCategoryId(subCategory.getSubCategoryId());
		dto.setSubCategoryName(subCategory.getSubCategoryName());
		dto.setCategory(subCategory.getCategory());
		dto.setProducts(subCategory.getProducts());

		return dto;
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		logger.info("Fetching all Sub Categories...");

		return repo.findAll();
	}

	@Override
	public SubCategory getSubCategoryByName(String name) {
		return repo.findBySubCategoryName(name).orElse(null);

	}

}
