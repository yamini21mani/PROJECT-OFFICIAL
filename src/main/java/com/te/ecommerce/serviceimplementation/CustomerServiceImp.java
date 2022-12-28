package com.te.ecommerce.serviceimplementation;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.UserDto;
import com.te.ecommerce.entity.BillingAddress;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.entity.SalesOrder;
import com.te.ecommerce.entity.ShippingAddress;
import com.te.ecommerce.entity.User;
import com.te.ecommerce.exceptionhandling.CredentialsException;
import com.te.ecommerce.exceptionhandling.GeneralException;
import com.te.ecommerce.exceptionhandling.ProductException;
import com.te.ecommerce.repository.BillingAddressRepository;
import com.te.ecommerce.repository.CartRepository;
import com.te.ecommerce.repository.CustomerRepository;
import com.te.ecommerce.repository.ProductRepository;
import com.te.ecommerce.repository.SalesOrderRepository;
import com.te.ecommerce.repository.ShippingAddressRepository;
import com.te.ecommerce.repository.UserRepository;
import com.te.ecommerce.serviceinterface.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
//	@Autowired
//	private OtpGenerator otpGenerator;
	@Autowired
	private ShippingAddress shippingAddress;
	@Autowired
	private SalesOrder salesOrder;
	@Autowired
	private BillingAddress billingAddress;
//	@Autowired
//	UserDetailsServiceAutoConfiguration userDetailsServiceAutoConfiguration;
	@Autowired
	private Cart cart;
//registeration
	public boolean register(Customer customer) {
			billingAddressRepository.save(customer.getBillingAddress());
			shippingAddressRepository.save(customer.getShippingAddress());
			userRepository.save(customer.getUser());
			cartRepository.save(customer.getCart());
			
			Customer registerdetails = customerRepository.save(customer);
			if (registerdetails != null)
				return true;
		else
			throw new CredentialsException("Something went wrong");
	}
//Search API's
	@Override
	public Product searchProductbyId(ProductDto productDto) {
		List<Product> allproducts = productRepository.findAll();
		for (Product product : allproducts) {
			if (productDto.getId() == product.getId())
				return product;
			else
				throw new ProductException("No relevant matches, Please check product ID");
		}
		return null;
	}

	@Override
	public Product searchProductbyCategory(ProductDto productDto) {
		List<Product> allproducts = productRepository.findAll();
		for (Product product : allproducts) {
			if (productDto.getCategory() == product.getCategory())
				return product;
			else
				throw new ProductException("No relevant matches, Please check product ID");
		}
		return null;

	}

	@Override
	public Product searchProductbyName(ProductDto productDto) {
		List<Product> allproducts = productRepository.findAll();
		for (Product product : allproducts) {
			if (productDto.getName() == product.getName())
				return product;
			else
				throw new ProductException("No relevant matches, Please check product ID");
		}
		return null;
	}
//List products 

	@Override
	public List<Product> productList() {
		List<Product> findAll = productRepository.findAll();
		return findAll;
	}
//Customer CRUD API's
	@Override
	public Customer updateCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		Customer founddata = customerRepository.findById(customer.getId())
				.orElseThrow(() -> new CredentialsException("no data found, please check the customerID"));
		if (founddata != null) {
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setPhoneno(customerDto.getPhoneno());
			customer.setBillingAddress(billingAddress);
			customer.getCart().setId(cart.getId());
			customer.setShippingAddress(shippingAddress);
			customerRepository.save(customer);
		}
		return customer;

	}
//	@Override
//	public Customer updatePhoneno(CustomerDto customerDto) {
//		BeanUtils.copyProperties(customerDto, customer);
//		Customer founddata = customerRepository.findById(customer.getId())
//				.orElseThrow(() -> new CredentialsException("no data found, please check the customerID"));		return null;
//				if (founddata != null) {
//				customer.setPhoneno(customerDto.getPhoneno());
//				customerRepository.save(customer);
//				return customer
//				
//	}

	

	@Override
	public void deleteCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		Customer founddata = customerRepository.findById(customer.getId())
				.orElseThrow(() -> new CredentialsException("No data found, please enter right Customer ID"));
		customerRepository.delete(founddata);
	}

	@Override
	public Customer getCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		Customer getCustomer = customerRepository.findById(customer.getId())
				.orElseThrow(() -> new CredentialsException("No data found,"));
		return getCustomer;
	}
	@Override
	public SalesOrder createSalesOrder(CustomerDto customerDto) {
		Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);
			salesOrder.setId(customer.getId());
			SalesOrder save = salesOrderRepository.save(salesOrder);
			
			return save;
	}
	@Override
	public User login(UserDto userDto) {
		User user=new User();
		BeanUtils.copyProperties(userDto, user);
		User data = userRepository.findById(user.getId()).orElseThrow(()-> new GeneralException("Unable to authenticate"));
//		UserDetailsServiceAutoConfiguration autoConfiguration;
		
		return data;
		}

	}
	
	
	

	

