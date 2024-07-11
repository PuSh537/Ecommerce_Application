package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.ProductDTO;
import com.wipro.ecommerce.dto.SellerDTO;
import com.wipro.ecommerce.dto.SubCategoryDTO;
import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.Order;
import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.entity.Seller;
import com.wipro.ecommerce.entity.SubCategory;
import com.wipro.ecommerce.exception.ProductNotFoundException;
import com.wipro.ecommerce.exception.SellerNotFoundException;
import com.wipro.ecommerce.exception.SubCategoryNotFoundException;
import com.wipro.ecommerce.repository.SellerRepository;

@Service
public class SellerServiceImp implements ISellerService {
	@Autowired
	SellerRepository repo;
	@Autowired
	IOrderService orderService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	ISubCategoryService subCategoryService;
	@Autowired
	IProductService productService;
	@Autowired
	PasswordEncoder passwordEncoder;

	private static final Logger logger = LoggerFactory.getLogger(SellerServiceImp.class);

	@Override
	public SellerDTO registerSeller(SellerDTO sellerDTO) {
		logger.info("Adding a seller..");
		Seller seller = new Seller();
		seller.setAddress(sellerDTO.getAddress());
		seller.setSellerName(sellerDTO.getSellerName());
		seller.setBusinessName(sellerDTO.getBusinessName());
		seller.setEmail(sellerDTO.getEmail());
		seller.setOrder(sellerDTO.getOrders());
		seller.setPhoneNumber(sellerDTO.getPhoneNumber());
		seller.setProduct(sellerDTO.getProduct());
		seller.setSellerId(sellerDTO.getSellerId());
		seller.setSellingDomain(sellerDTO.getSellingDomain());
//		seller.setPassword(passwordEncoder.encode(sellerDTO.getPassword()));
		seller.setRole(sellerDTO.getRole());
		seller.setUsername(sellerDTO.getUsername());
		seller.setPassword(passwordEncoder.encode(sellerDTO.getPassword()));
		repo.save(seller);
		return sellerDTO;

	}

	@Override
	public Seller updateSeller(SellerDTO sellerDTO) throws SellerNotFoundException {
		Seller seller = repo.findById(sellerDTO.getSellerId()).orElse(null);
		if (seller == null) {
			throw new SellerNotFoundException("Seller with sellerId: " + sellerDTO.getSellerId() + " not found.");
		}
		logger.info("Updating the seller record...");
		seller.setAddress(sellerDTO.getAddress());
		seller.setSellerName(sellerDTO.getSellerName());
		seller.setBusinessName(sellerDTO.getBusinessName());
		seller.setEmail(sellerDTO.getEmail());
		seller.setOrder(sellerDTO.getOrders());
		seller.setPhoneNumber(sellerDTO.getPhoneNumber());
		seller.setProduct(sellerDTO.getProduct());
		seller.setSellerId(sellerDTO.getSellerId());
		seller.setSellingDomain(sellerDTO.getSellingDomain());
		seller.setPassword(sellerDTO.getPassword());
		seller.setRole(sellerDTO.getRole());
		seller.setUsername(sellerDTO.getUsername());
		return repo.save(seller);
	}

	@Override
	public String deleteSellerById(int sellerId) throws SellerNotFoundException {
		Seller seller = repo.findById(sellerId).orElse(null);
		if (seller == null) {
			throw new SellerNotFoundException("Seller with sellerId: " + sellerId + " not found.");
		}
		logger.info("Deleting the seller with sellerId: " + sellerId);
		repo.deleteById(sellerId);
		return "Seller with sellerID " + sellerId + " deleted.";
	}

	@Override
	public SellerDTO getSellerById(int sellerId) throws SellerNotFoundException {
		Seller seller = repo.findById(sellerId).orElse(null);
		if (seller == null) {
			throw new SellerNotFoundException("Seller with sellerId: " + sellerId + " not found.");
		}
		SellerDTO dto = new SellerDTO();
		dto.setAddress(seller.getAddress());
		dto.setSellerName(seller.getSellerName());
		dto.setBusinessName(seller.getBusinessName());
		dto.setEmail(seller.getEmail());
		dto.setOrders(seller.getOrder());
		dto.setPhoneNumber(seller.getPhoneNumber());
		dto.setProduct(seller.getProduct());
		dto.setSellerId(seller.getSellerId());
		dto.setSellingDomain(seller.getSellingDomain());
		dto.setPassword(seller.getPassword());
		dto.setRole(seller.getRole());
		dto.setUsername(seller.getUsername());
		return dto;
	}

	@Override
	public List<Seller> getAllSeller() {
		logger.info("Fetching all Sellers..");
		return repo.findAll();
	}

	@Override
	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}

	@Override
	public List<Product> getAllProduct() {

		return productService.getAllProduct();
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		return subCategoryService.getAllSubCategory();
	}

	@Override
	public Product addProduct(ProductDTO productdto) {
		return productService.addProduct(productdto);
	}

	@Override
	public Product updateProduct(ProductDTO productdto) throws ProductNotFoundException {
		return productService.updateProduct(productdto);
	}

	@Override
	public String deleteProduct(int id) throws ProductNotFoundException {

		return productService.deleteProductById(id);
	}

	@Override
	public Product getProductbyName(String name) throws ProductNotFoundException {
		return productService.getByName(name);
	}

	@Override
	public ProductDTO getProductById(int id) throws ProductNotFoundException {
		return productService.getProductById(id);
	}

	@Override

//	public ProductDTO markProductOutOfStock(int sellerId, int productId) throws ProductNotFoundException {
//		ProductDTO productDTO = productService.getProductById(productId);
//		 if (productDTO == null) {
//		        throw new ProductNotFoundException("Product with productId: " + productId + " not found.");
//		    }
//		if (productDTO.getSeller().getSellerId() == sellerId) {
//            productDTO.setStockQuantity(0);
//            productService.updateProduct(productDTO);
//            System.err.println(productDTO);
//            return productDTO;
//		}
//		else {
//	        throw new IllegalArgumentException("Product does not belong to the seller");
//	    }
//	}
//

	public ProductDTO markProductOutOfStock(int sellerId, int productId) throws ProductNotFoundException {
		ProductDTO productDTO = productService.getProductById(productId);
		if (productDTO == null) {
			throw new ProductNotFoundException("Product with productId: " + productId + " not found.");
		}

		// Debug logging
		System.out.println("SellerId from request: " + sellerId);
		System.out.println("SellerId from product: " + productDTO.getSeller().getSellerId());

		if (productDTO.getSeller().getSellerId() == sellerId) {
			productDTO.setStockQuantity(0);

			productService.updateProduct(productDTO);
			return productDTO;
		} else {
			throw new IllegalArgumentException("Product does not belong to the seller");
		}
	}

	@Override
	public String login(String username, String password) {
		return null;
	}

	@Override
	public Optional<Seller> fetchSellerDetails(String username) throws SellerNotFoundException {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}

	@Override
	public List<Product> viewMyProducts(int sellerId) throws ProductNotFoundException {
		return productService.getAllProductBySellerId(sellerId);
	}

	@Override
	public SubCategoryDTO getSubcategoryById(int subCategoryId) throws SubCategoryNotFoundException {
		// TODO Auto-generated method stub
		return subCategoryService.getSubCategoryById(subCategoryId);
	}

	@Override
	public List<Integer> getOrdersBySellerId(int sellerId) {
		// TODO Auto-generated method stub
		return repo.getOrdersBySellerId(sellerId);
	}

	@Override
	public List<Integer> getPaymentsOfSeller(int sellerId) {
		// TODO Auto-generated method stub
		return repo.getPaymentsOfSeller(sellerId);
	}
}
