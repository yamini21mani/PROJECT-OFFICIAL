package com.te.ecommerce.serviceinterface;

import java.util.List;

import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.UserDto;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.entity.SalesOrder;
import com.te.ecommerce.entity.User;

public interface CustomerService {
	//registeration API
	public boolean register(Customer customer);
	//Search API's for products
	public Product searchProductbyId(ProductDto productDto);
	public Product searchProductbyName(ProductDto productDto);
	public Product searchProductbyCategory(ProductDto productDto);

	public List<Product> productList();
	
	public Customer updateCustomer(CustomerDto customerDto);
//	public Customer updatePhoneno(CustomerDto customerDto);
	public void deleteCustomer(CustomerDto customerDto);
	public Customer getCustomer(CustomerDto customerDto);
	
	public SalesOrder createSalesOrder(CustomerDto customerDto);
	
	public User login(UserDto userDto);
	
	
	
}
