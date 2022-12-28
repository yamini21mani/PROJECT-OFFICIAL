package com.te.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.AddressDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.UserDto;
import com.te.ecommerce.entity.BillingAddress;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.entity.ShippingAddress;
import com.te.ecommerce.response.EcommerceResponse;
import com.te.ecommerce.serviceimplementation.BillingAddressServImp;
import com.te.ecommerce.serviceimplementation.CustomerServiceImp;
import com.te.ecommerce.serviceimplementation.ProductServiceImp;
import com.te.ecommerce.serviceimplementation.ShippingAddressServImp;

@RestController
public class CustomerController {
	@Autowired
	private EcommerceResponse ecommerceResponse;
	@Autowired
	private CustomerServiceImp serviceImp;
	@Autowired
	private ShippingAddressServImp shippingAddressServImp;
	@Autowired
	private BillingAddressServImp billingAddressServImp;
	@Autowired
	private ProductServiceImp productServiceImp;

//registeration
	@PostMapping("/register")
	public ResponseEntity<EcommerceResponse> register(@RequestBody Customer customer) {
		serviceImp.register(customer);
		ecommerceResponse.setMessage("registeration successful");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getProductdetails")
	public ResponseEntity<EcommerceResponse> getProduct(@RequestBody ProductDto productDto) {
		Product product = productServiceImp.getProduct(productDto);
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(product);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

//Search products by name, id and category
	@GetMapping("/searchproductbyId")
	public ResponseEntity<EcommerceResponse> searchProductbyId(@RequestBody ProductDto productDto) {
		serviceImp.searchProductbyId(productDto);
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@GetMapping("/searchProductbyName")
	public ResponseEntity<EcommerceResponse> searchProductbyName(@RequestBody ProductDto productDto) {
		serviceImp.searchProductbyName(productDto);
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@GetMapping("/searchProductbyCategory")
	public ResponseEntity<EcommerceResponse> searchProductbyCategory(@RequestBody ProductDto productDto) {
		serviceImp.searchProductbyCategory(productDto);
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

//fetch products list
	@GetMapping("/productlist")
	public ResponseEntity<EcommerceResponse> productList() {
		List<Product> findAll = serviceImp.productList();
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(findAll);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

//CRUD customer API's
	@PutMapping("/updateCustomer")
	public ResponseEntity<EcommerceResponse> updateCustomer(@RequestBody CustomerDto customerDto) {
		Customer updateCustomer = serviceImp.updateCustomer(customerDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(updateCustomer);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}
//	@PutMapping("/updatephoneno")
//	public ResponseEntity<EcommerceResponse> updatePhoneno(@RequestBody CustomerDto customerDto) {
//		Customer updateCustomer = serviceImp.updatePhoneno(customerDto);
//		ecommerceResponse.setMessage("Customer data modified successfully");
//		ecommerceResponse.setError(false);
//		ecommerceResponse.setStatus("200");
//		ecommerceResponse.setData(updateCustomer);
//		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
//
//	}
//
//	@PutMapping("/updateCustomer")
//	public ResponseEntity<EcommerceResponse> updateCustomer(@RequestBody CustomerDto customerDto) {
//		Customer updateCustomer = serviceImp.updateCustomer(customerDto);
//		ecommerceResponse.setMessage("Customer data modified successfully");
//		ecommerceResponse.setError(false);
//		ecommerceResponse.setStatus("200");
//		ecommerceResponse.setData(updateCustomer);
//		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
//
//	}
//
//	@PutMapping("/updateCustomer")
//	public ResponseEntity<EcommerceResponse> updateCustomer(@RequestBody CustomerDto customerDto) {
//		Customer updateCustomer = serviceImp.updateCustomer(customerDto);
//		ecommerceResponse.setMessage("Customer data modified successfully");
//		ecommerceResponse.setError(false);
//		ecommerceResponse.setStatus("200");
//		ecommerceResponse.setData(updateCustomer);
//		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
//
//	}


	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<EcommerceResponse> deleteCustomer(@RequestBody CustomerDto customerDto) {
		serviceImp.deleteCustomer(customerDto);
		ecommerceResponse.setMessage("Customer data deleted successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getCustomer")
	public ResponseEntity<EcommerceResponse> getCustomer(@RequestBody CustomerDto customerDto) {
		serviceImp.getCustomer(customerDto);
//		ecommerceResponse.setMessage("Customer data deleted successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

//Shipping Address CRUD
	@PostMapping("/addShippingAddress")
	public ResponseEntity<EcommerceResponse> addShippingAddress(@RequestBody AddressDto addressDto) {
		boolean updateCustomer = shippingAddressServImp.addShippingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(updateCustomer);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getShippingAddress")
	public ResponseEntity<EcommerceResponse> getShippingAddress(@RequestBody AddressDto addressDto) {
		ShippingAddress updateCustomer = shippingAddressServImp.getShippingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(updateCustomer);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/updateShippingAddress")
	public ResponseEntity<EcommerceResponse> updateShippingAddress(@RequestBody AddressDto addressDto) {
		ShippingAddress updateCustomer = shippingAddressServImp.updateShippingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(updateCustomer);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteshippingAddress")
	public ResponseEntity<EcommerceResponse> deleteShippingAddress(@RequestBody AddressDto addressDto) {
		shippingAddressServImp.deleteShippingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
//	ecommerceResponse.setData(updateCustomer);		
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/addBillingAddress")
	public ResponseEntity<EcommerceResponse> addBillingAddress(@RequestBody AddressDto addressDto) {
		boolean addaddress = billingAddressServImp.addBillingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(addaddress);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/getBillingAddress")
	public ResponseEntity<EcommerceResponse> getBillingAddress(@RequestBody AddressDto addressDto) {
		BillingAddress getaddress = billingAddressServImp.getBillingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(getaddress);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/updateBillingAddress")
	public ResponseEntity<EcommerceResponse> updateBillingAddress(@RequestBody AddressDto addressDto) {
		BillingAddress updateCustomer = billingAddressServImp.updateBillingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(updateCustomer);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/deleteBillingAddress")
	public ResponseEntity<EcommerceResponse> deleteBillingAddress(@RequestBody AddressDto addressDto) {
		billingAddressServImp.deleteBillingAddress(addressDto);
		ecommerceResponse.setMessage("Customer data modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
//	ecommerceResponse.setData(updateCustomer);		
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}
	
	public ResponseEntity<EcommerceResponse> login(@RequestBody UserDto userDto ){
		serviceImp.login(userDto);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

}
