package com.wipro.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.Product;

public class SubCategoryDTO {
	
	 private int subCategoryId;     
	    private String subCategoryName;
	    private Category category;
	    @JsonIgnore
	    private List<Product> products= new ArrayList<Product>();
		
	    public SubCategoryDTO() {
			super();
		}
		public SubCategoryDTO(int subCategoryId, String subCategoryName, Category category, List<Product> products) {
			super();
			this.subCategoryId = subCategoryId;
			this.subCategoryName = subCategoryName;
			this.category = category;
			this.products = products;
		}





		public SubCategoryDTO(int subCategoryId, String subCategoryName, Category category) {
			super();
			this.subCategoryId = subCategoryId;
			this.subCategoryName = subCategoryName;
			this.category = category;
		}





		public int getSubCategoryId() {
			return subCategoryId;
		}

		public void setSubCategoryId(int subCategoryId) {
			this.subCategoryId = subCategoryId;
		}

		public String getSubCategoryName() {
			return subCategoryName;
		}

		public void setSubCategoryName(String subCategoryName) {
			this.subCategoryName = subCategoryName;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

	

		@Override
		public String toString() {
			return "SubCategoryDTO [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName
					+ ", category=" + category + ", products=" + products + "]";
		}

		


}
