package com.wipro.ecommerce.dto;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wipro.ecommerce.entity.SubCategory;

public class CategoryDTO {
	
	private int categoryId;   
    private String categoryName;
    @JsonIgnore
    private List<SubCategory> subCategories =new ArrayList<SubCategory>();
    public CategoryDTO() {
		super();
	}
    

	public CategoryDTO(int categoryId, String categoryName) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}


	public CategoryDTO(int categoryId, String categoryName, List<SubCategory> subCategories) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	

}
