package com.wipro.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "seller_Id")
	private Seller seller;
	@NotBlank
	private String productName;
	@NotBlank
	private String productImageURL;
	@NotBlank
	private String description;
	@Positive
	private double price;
	@PositiveOrZero
	private int stockQuantity;
	@NotBlank
	private String brand;
	@PastOrPresent
	private LocalDateTime createdAt;
	@PastOrPresent
	private LocalDateTime modifiedAt;
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<OrderItem> orderItems;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "subcategory_Id")
	private SubCategory subCategory;

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImageURL() {
		return productImageURL;
	}

	public void setProductImageURL(String productImageURL) {
		this.productImageURL = productImageURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", seller=" + seller + ", productName=" + productName
				+ ", productImageURL=" + productImageURL + ", description=" + description + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + ", brand=" + brand + ", createdAt=" + createdAt + ", modifiedAt="
				+ modifiedAt + ", subCategory=" + subCategory + "]";
	}

	public Product(int productId, Seller seller, @NotBlank String productName, @NotBlank String productImageURL,
			@NotBlank String description, @Positive double price, @Min(1) int stockQuantity, @NotBlank String brand,
			@PastOrPresent LocalDateTime createdAt, @PastOrPresent LocalDateTime modifiedAt, SubCategory subCategory) {
		super();
		this.productId = productId;
		this.seller = seller;
		this.productName = productName;
		this.productImageURL = productImageURL;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.brand = brand;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.subCategory = subCategory;

	}

}
