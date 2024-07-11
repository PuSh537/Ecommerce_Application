package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.AdminDTO;
import com.wipro.ecommerce.dto.PaymentDTO;
import com.wipro.ecommerce.dto.SubCategoryDTO;
import com.wipro.ecommerce.entity.Admin;
import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.entity.Order;
import com.wipro.ecommerce.entity.OrderItem;
import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.entity.Seller;
import com.wipro.ecommerce.entity.SubCategory;
import com.wipro.ecommerce.exception.AdminNotFoundException;
import com.wipro.ecommerce.exception.CategoryNotFoundException;
import com.wipro.ecommerce.exception.CustomerNotFoundException;
import com.wipro.ecommerce.exception.ProductNotFoundException;
import com.wipro.ecommerce.exception.SellerNotFoundException;
import com.wipro.ecommerce.exception.SubCategoryNotFoundException;
import com.wipro.ecommerce.repository.AdminRepository;
import com.wipro.ecommerce.repository.CategoryRepository;

@Service
public class AdminServiceImp implements IAdminService {
	@Autowired
	AdminRepository adminrepo;

	@Autowired
	IProductService productService;

	@Autowired
	ISellerService sellerService;

	@Autowired
	ICustomerService customerService;

	@Autowired
	ICategoryService categoryService;

	@Autowired
	ISubCategoryService subcategoryService;

	@Autowired
	IPaymentService paymentService;

	@Autowired
	IOrderService orderService;

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	IOrderItemService orderItemService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public String addAdmin(AdminDTO admindto) {
		Admin admin = new Admin();
		admin.setAdminID(admindto.getAdminID());
		admin.setAdminName(admindto.getAdminName());
		admin.setEmail(admindto.getEmail());
		admin.setJoiningDate(admindto.getJoiningDate());
		admin.setPassword(passwordEncoder.encode(admindto.getPassword()));
		admin.setPhoneNumber(admindto.getPhoneNumber());
		admin.setRole(admindto.getRole());
		admin.setUsername(admindto.getUsername());
		adminrepo.save(admin);
		return "New Admin records added.";

	}

	@Override
	public List<Product> viewAllProducts() {
		return productService.getAllProduct();
	}

	@Override
	public String deleteProduct(int id) throws ProductNotFoundException {
		return productService.deleteProductById(id);
	}

	@Override
	public String deleteCategory(int id) throws CategoryNotFoundException {
		return categoryService.deleteCategoryById(id);
	}

	@Override
	public String deleteSubCategory(int id) throws SubCategoryNotFoundException {
		return subcategoryService.deleteSubCategoryById(id);
	}

	@Override
	public List<Customer> viewAllCustomer() {
		return customerService.getAllCustomer();
	}

	@Override
	public List<Seller> viewAllSeller() {

		return sellerService.getAllSeller();
	}

	@Override
	public List<Order> viewAllOrder() {
		return orderService.getAllOrder();
	}

	@Override
	public List<Payment> viewAllPayment() {
		return paymentService.getAllPayment();
	}

	@Override
	public String deleteSeller(int id) throws SellerNotFoundException {
		return sellerService.deleteSellerById(id);
	}

	@Override
	public List<Category> viewAllCategory() {
		return categoryService.getAllCategory();
	}

	@Override
	public List<SubCategory> viewAllSubCategory() {
		return subcategoryService.getAllSubCategory();
	}

	@Override
	public Payment addPayment(PaymentDTO payment) {
		return paymentService.addPayment(payment);
	}

	@Override
	public Category addCategory(Category category) {

		return categoryRepo.save(category);
	}

	@Override
	public SubCategory addSubCategory(SubCategoryDTO subcategorydto) {
		return subcategoryService.addSubCategory(subcategorydto);
	}

	@Override
	public String deleteCustomer(int id) throws CustomerNotFoundException {
		return customerService.deleteCustomerById(id);
	}

	@Override
	public Optional<Admin> fetchAdminDetails(String username) throws AdminNotFoundException {

		return adminrepo.findByUsername(username);
	}

	@Override
	public Admin viewAdminById(int adminId) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		return adminrepo.findById(adminId).orElse(null);
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId) {
		return orderItemService.getOrderItemsByOrderId(orderId);
	}

}
