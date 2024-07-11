package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.dto.CategoryDTO;
import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.SubCategory;
import com.wipro.ecommerce.exception.CategoryNotFoundException;

public interface ICategoryService {
	 public Category addCategory(CategoryDTO categoryDTO);
     public Category updateCategory(CategoryDTO categoryDTO) throws CategoryNotFoundException;
     public String deleteCategoryById(int categoryId) throws CategoryNotFoundException;
     public CategoryDTO getCategoryById(int categoryId) throws CategoryNotFoundException;
     public List<Category> getAllCategory();
    public List<SubCategory> getSubCategoryIdByCategoryId(int categoryId) throws CategoryNotFoundException;

    
    public Category getCategorybyName(String name);
}
