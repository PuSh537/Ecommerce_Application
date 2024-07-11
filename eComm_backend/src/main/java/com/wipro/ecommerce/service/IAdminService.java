package com.wipro.ecommerce.service;

import java.util.List;
import java.util.Optional;

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

public interface IAdminService {
    
    public String addAdmin(AdminDTO admindto);
    
    public List<Product> viewAllProducts();
    
    public String deleteProduct(int id) throws ProductNotFoundException;
    
    public String deleteCategory(int id) throws CategoryNotFoundException;
   
    public String deleteSubCategory(int id) throws SubCategoryNotFoundException;
    
    public List<Customer> viewAllCustomer();
    
    public List<Seller> viewAllSeller();
    
    public List<Order> viewAllOrder();
    
    public List<Payment> viewAllPayment();
    
    public  String deleteSeller(int id) throws SellerNotFoundException;
    
    public String deleteCustomer(int id) throws CustomerNotFoundException;
     
    public List<Category> viewAllCategory();
    
    public List<SubCategory> viewAllSubCategory();
    
    public Payment addPayment(PaymentDTO payment);
    
    public Category addCategory(Category category);
    
    public SubCategory addSubCategory(SubCategoryDTO subcategorydto);

	public Optional<Admin> fetchAdminDetails(String username) throws AdminNotFoundException;

	public Admin viewAdminById(int adminId) throws AdminNotFoundException;

	List<OrderItem> getOrderItemsByOrderId(int orderId); 
    
    
      
}
