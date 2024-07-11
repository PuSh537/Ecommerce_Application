package com.wipro.ecommerce.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.ecommerce.dto.CustomerDTO;
import com.wipro.ecommerce.dto.ProductDTO;
import com.wipro.ecommerce.entity.Address;
import com.wipro.ecommerce.entity.Cart;
import com.wipro.ecommerce.entity.CartItem;
import com.wipro.ecommerce.entity.Category;
import com.wipro.ecommerce.entity.Customer;
import com.wipro.ecommerce.entity.Order;
import com.wipro.ecommerce.entity.OrderItem;
import com.wipro.ecommerce.entity.Payment;
import com.wipro.ecommerce.entity.Product;
import com.wipro.ecommerce.entity.SubCategory;
import com.wipro.ecommerce.exception.CustomerNotFoundException;
import com.wipro.ecommerce.exception.ProductNotFoundException;
import com.wipro.ecommerce.repository.AddressRepository;
import com.wipro.ecommerce.repository.CustomerRepository;
import com.wipro.ecommerce.repository.OrderRepository;
import com.wipro.ecommerce.repository.ProductRepository;

import jakarta.persistence.EntityManager;

@Service
public class CustomerServiceImp implements ICustomerService {
	@Autowired
	CustomerRepository repo;
	@Autowired
	ProductRepository productRepo;
	@Autowired
	IProductService productService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	ISubCategoryService subcategoryService;
	@Autowired
	ICartItemService cartitemService;
	@Autowired
	IOrderService orderService;
	@Autowired
	IPaymentService paymentService;
	@Autowired
	ICartService cartService;
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

//    @Autowired
//    CustomerDTO customerDTO;

	CustomerDTO customerDTO = new CustomerDTO();

	@Autowired
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);

	@Override
	public String registerCustomer(CustomerDTO customerDTO) {
		logger.info("Adding new Customer-----------------------", customerDTO);
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddress(customerDTO.getAddress());
		customer.setAddress(customerDTO.getAddress());
		// customer.setPassword(customerDTO.getPassword());;
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
		Address savedAddress = addressRepository.save(customerDTO.getAddress()); // Save address using JPA
		customer.setAddress(savedAddress);
		customer.setRole(customerDTO.getRole());
		customer.setUsername(customerDTO.getUsername());

		repo.save(customer);
		return "New customer Registered";
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException {
		logger.info("Updating the customer");
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddress(customerDTO.getAddress());
		customer.setCart(customerDTO.getCart());
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
		// customer.setPassword(customerDTO.getPassword());
		customer.setRole(customerDTO.getRole());
		customer.setUsername(customerDTO.getUsername());
		return repo.save(customer);
		// return "Updated customer";

	}

	@Override
	public String deleteCustomerById(int customerId) throws CustomerNotFoundException {
		logger.info("Deleting the customer with customerId " + customerId);
		repo.deleteById(customerId);
		return "Customer with customerId " + customerId + " deleted.";
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) throws CustomerNotFoundException {
		Customer customer = repo.findById(customerId).orElse(null);
		if (customer == null) {
			logger.warn("Customer with ID " + customerId + "not found.");
		}
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(customer.getCustomerId());
		dto.setEmail(customer.getEmail());
		dto.setUsername(customer.getUsername());
		dto.setGender(customer.getGender());
		dto.setContactNumber(customer.getContactNumber());
		dto.setAddress(customer.getAddress());
		dto.setCart(customer.getCart());
		// dto.setPassword(customer.getPassword());
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
		dto.setRole(customer.getRole());
		dto.setCustomerName(customer.getCustomerName());
		return dto;
	}

	@Override
	public List<Customer> getAllCustomer() {
		logger.info("Fetching all Customers...");

		return repo.findAll();
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
		return subcategoryService.getAllSubCategory();
	}

	@Override
	public Product getProductByName(String name) {
		return productService.getByName(name);
	}

	@Override
	public Category getCategorybyName(String name) {
		return categoryService.getCategorybyName(name);
	}

	@Override
	public SubCategory getSubCategoryByName(String name) {
		return subcategoryService.getSubCategoryByName(name);
	}

	public String addProductToCustomerCart(int customerId, int productId, int quantity)
			throws ProductNotFoundException {

		Customer customer = repo.findById(customerId).orElse(null);

		Cart cart = customer.getCart();
		if (cart == null) {

			cart = new Cart();
			cart.setCustomer(customer);
			customer.setCart(cart);
		}
		ProductDTO productDTO = productService.getProductById(productId);
		Product product = productService.updateProduct(productDTO);

		if (product.getStockQuantity() >= quantity) {
			CartItem existingCartItem = cart.getCartItems().stream().filter(item -> item.getProduct().equals(product))
					.findFirst().orElse(null);
			if (existingCartItem != null) {
				if (quantity < existingCartItem.getItemQuantity()) {
					existingCartItem.setItemQuantity(quantity);
				} else {
					existingCartItem.setItemQuantity(quantity);
				}
			} else {

				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setItemQuantity(quantity);
				cart.getCartItems().add(cartItem);
			}
			double totalPrice = cart.getCartItems().stream()
					.mapToDouble(item -> item.getItemQuantity() * item.getProduct().getPrice()).sum();
			cart.setTotalPrice(totalPrice);
			repo.save(customer);
			return "Added to the cart.";
		}

		return "Maximum " + product.getStockQuantity() + "products can be added";

	}

	@Override
	public List<CartItem> viewCartitems(int customerId) {

		Customer customer = repo.findById(customerId).orElse(null);
		Cart cart = customer.getCart();
		if (cart != null) {
			return cart.getCartItems();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Product> getProductsByBrand(String brand) {
		return productService.getByBrand(brand);
	}

	@Override
	public List<Product> getProductsByPriceRange(double min, double max) {

		return productService.getByPriceRange(min, max);
	}

	@Override
	public String placeOrder(int customerId, String paymentMethod, String otp) throws ProductNotFoundException {
		Customer customer = repo.findById(customerId).orElse(null);
		if (customer == null) {
			return "Customer not found.";
		}

		Cart cart = customer.getCart();
		if (cart == null || cart.getCartItems().isEmpty()) {
			return "Cart is empty. Cannot place an order.";
		}
		if (true) {
			Order order = new Order();
			order.setCustomer(customer);
			order.setOrderDate(LocalDate.now());

			List<OrderItem> orderItems = new ArrayList<>();
			for (CartItem cartItem : cart.getCartItems()) {
				int productId = cartItem.getProduct().getProductId();
				ProductDTO productDTO = productService.getProductById(productId);
				Product product = productService.updateProduct(productDTO);
				OrderItem orderItem = new OrderItem();
				orderItem.setOrder(order);
				orderItem.setProduct(product);
				orderItem.setQuantity(cartItem.getItemQuantity());
				orderItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getItemQuantity());
				orderItem.setSeller(cartItem.getProduct().getSeller());
				orderItem.setStatus("Pending");
				orderItem.setStatusDescription("Order placed. Pending processing.");
				orderItem.setDeliveryDate(LocalDate.now().plusDays(7));
				orderItems.add(orderItem);

				Product updateProduct = cartItem.getProduct();
				updateProduct.setStockQuantity(updateProduct.getStockQuantity() - cartItem.getItemQuantity());
			}

			double totalAmount = orderItems.stream().mapToDouble(item -> item.getPrice()).sum();
			order.setTotalAmount(totalAmount);

			Payment payment = new Payment();
			payment.setAmount(totalAmount);
			payment.setPaymentDate(LocalDateTime.now());
			payment.setPaymentMethod(paymentMethod);
			if (paymentMethod == "COD" || paymentMethod == "cod") {
				payment.setPaymentStatus("Payment To be done at the time of delivery.");
			} else {
				payment.setPaymentStatus("Payment Done.");
			}
			order.setPayment(payment);
			int cartdelete = customer.getCart().getCartId();

			order.setOrderItems(orderItems);
			customer.getOrder().add(order);
			orderRepo.save(order);
			customer.setCart(null);
			repo.save(customer);
			for (CartItem cartItem : cart.getCartItems()) {

				cartitemService.deleteCartItemById(cartItem.getCartitemId());
			}
			cartService.deleteCartById(cartdelete);

			cart.getCartItems().clear();

			return "Order placed successfully.";
		} else {
			return "OTP validation failed. Order not placed.";
		}
	}

	@Override
	public Optional<Customer> fetchCustomerDetails(String username) throws CustomerNotFoundException {
		return repo.findByUsername(username);
	}

	@Override
	public String deleteProductFromCustomerCart(int customerId, int productId) {
		Customer customer = repo.findById(customerId).orElse(null);
		if (customer == null) {
			return "Customer not found";
		}

		Cart cart = customer.getCart();
		if (cart == null || cart.getCartItems().isEmpty()) {
			return "Cart is empty";
		}

		Optional<CartItem> itemToRemove = cart.getCartItems().stream()
				.filter(item -> item.getProduct().getProductId() == productId).findFirst();

		if (itemToRemove.isPresent()) {
			cart.getCartItems().remove(itemToRemove.get());
			double totalPrice = cart.getCartItems().stream()
					.mapToDouble(item -> item.getItemQuantity() * item.getProduct().getPrice()).sum();
			cart.setTotalPrice(totalPrice);
			repo.save(customer);
			return "Product removed from the cart";
		} else {
			return "Product not found in the cart";
		}
	}

	@Override
	public List<Product> viewProductsBySubCategoryName(String subcategoryName) {
		subcategoryName = subcategoryName.trim();
		SubCategory subcategory = subcategoryService.getSubCategoryByName(subcategoryName);
		if (subcategory != null) {
			int subcategoryId = subcategory.getSubCategoryId();
			return productRepo.findBySubCategoryId(subcategoryId);
		}

		else {
			return new ArrayList<>();
		}

	}

	@Override
	public List<Order> viewOrderByCustomerId(int customerId) {

		return orderRepo.findOrderByCustomerId(customerId);
	}

}