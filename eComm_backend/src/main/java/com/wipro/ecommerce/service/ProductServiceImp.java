package com.wipro.ecommerce.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.ProductDTO;
import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.exception.ProductNotFoundException;
import com.wipro.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	ProductRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);

	@Override
	public Product addProduct(ProductDTO productDTO) {
		logger.info("Adding new Product");
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setBrand(productDTO.getBrand());
		product.setCreatedAt(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		product.setDescription(productDTO.getDescription());
		product.setModifiedAt(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		product.setPrice(productDTO.getPrice());
		product.setProductImageURL(productDTO.getProductImageURL());
		product.setProductName(productDTO.getProductName());
		product.setSeller(productDTO.getSeller());
		product.setStockQuantity(productDTO.getStockQuantity());
		product.setSubCategory(productDTO.getSubCategory());
		return repo.save(product);
	}

	@Override
	public Product updateProduct(ProductDTO productDTO) throws ProductNotFoundException {
		Product product = repo.findById(productDTO.getProductId()).orElse(null);
		if (product == null) {
			throw new ProductNotFoundException("Product with productId: " + productDTO.getProductId() + " not found.");
		}
		logger.info("Updating the Product...");
		product.setProductId(productDTO.getProductId());
		product.setBrand(productDTO.getBrand());
		// product.setCart(productDTO.getCart());
		// product.setCategory(productDTO.getCategory());
		product.setCreatedAt(productDTO.getCreatedAt());
		product.setDescription(productDTO.getDescription());
		product.setModifiedAt(productDTO.getModifiedAt());
		product.setPrice(productDTO.getPrice());
		product.setProductImageURL(productDTO.getProductImageURL());
		product.setProductName(productDTO.getProductName());
		product.setSeller(productDTO.getSeller());
		product.setStockQuantity(productDTO.getStockQuantity());
		product.setSubCategory(productDTO.getSubCategory());
		return repo.save(product);

	}

	@Override
	public String deleteProductById(int productId) throws ProductNotFoundException {
		Product product = repo.findById(productId).orElse(null);
		if (product == null) {
			throw new ProductNotFoundException("Product with productId: " + productId + " not found.");
		}
		logger.info("Deleting the product with productId: " + productId);
		repo.deleteById(productId);
		return "Product with productId " + productId + " deleted.";
	}

	@Override
	public ProductDTO getProductById(int productId) throws ProductNotFoundException {
		Product product = repo.findById(productId).orElse(null);
		if (product == null) {
			throw new ProductNotFoundException("Product with productId: " + productId + " not found.");
		}
		ProductDTO dto = new ProductDTO();
		dto.setProductId(product.getProductId());
		dto.setBrand(product.getBrand());
		dto.setCreatedAt(product.getCreatedAt());
		dto.setDescription(product.getDescription());
		dto.setModifiedAt(product.getModifiedAt());
		dto.setPrice(product.getPrice());
		dto.setProductImageURL(product.getProductImageURL());
		dto.setProductName(product.getProductName());
		dto.setSeller(product.getSeller());
		dto.setStockQuantity(product.getStockQuantity());
		dto.setSubCategory(product.getSubCategory());
		return dto;
	}

	@Override
	public List<Product> getAllProduct() {

		logger.info("Fetching all products...");

		return repo.findAll();
	}

	@Override
	public Product getByName(String name) {
		return repo.findByProductName(name).orElse(null);
	}

	@Override
	public List<Product> getByBrand(String brand) {
		return repo.findBybrand(brand);
	}

	@Override
	public List<Product> getByPriceRange(double min, double max) {
		return repo.findBypriceBetween(min, max);
	}

	@Override
	public List<Product> getAllProductBySellerId(int sellerId) {
		return repo.findBySellerId(sellerId);
	}

}
