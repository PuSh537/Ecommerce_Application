package com.wipro.ecommerce.service;

import java.util.List;

import com.wipro.ecommerce.dto.ProductDTO;
import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.exception.ProductNotFoundException;

public interface IProductService {
	public Product addProduct(ProductDTO productDTO);

	public Product updateProduct(ProductDTO productDTO) throws ProductNotFoundException;

	public String deleteProductById(int productId) throws ProductNotFoundException;

	public ProductDTO getProductById(int productId) throws ProductNotFoundException;

	public List<Product> getAllProduct();

	public Product getByName(String name);

	public List<Product> getByBrand(String brand);

	public List<Product> getByPriceRange(double min, double max);

	public List<Product> getAllProductBySellerId(int sellerId);
}
