package com.wipro.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int categoryId;      
    @NotBlank
    private String categoryName;
   
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="category", fetch = FetchType.LAZY)
   private List<SubCategory> subCategories =new ArrayList<SubCategory>();
 
	public Category() {
		super();
	}
	  public Category(int categoryId, @NotBlank String categoryName) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
		}

	public Category(int categoryId, @NotBlank String categoryName, List<SubCategory> subCategories) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategories = subCategories;
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

	
	  public List<SubCategory> getSubCategories() 
	  { return subCategories; }
	  

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategories="
				+ subCategories + "]";
	}
	 

	
    
    
}
