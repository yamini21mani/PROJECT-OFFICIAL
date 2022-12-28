package com.te.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.dto.RoleDto;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.response.EcommerceResponse;
import com.te.ecommerce.serviceimplementation.AdminServiceImp;
import com.te.ecommerce.serviceimplementation.CustomerServiceImp;
import com.te.ecommerce.serviceimplementation.ProductServiceImp;

@RestController
public class AdminController {
	@Autowired
	private ProductServiceImp productServiceImp;
	@Autowired
	private EcommerceResponse ecommerceResponse;
	@Autowired
	private CustomerServiceImp customerServiceImp;
	@Autowired
	private AdminServiceImp adminServiceImp;

	@PostMapping("/createProduct")
	public ResponseEntity<EcommerceResponse> createProduct(@RequestBody ProductDto productDto) {
		productServiceImp.createProduct(productDto);
		ecommerceResponse.setMessage("registeration successful");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	@GetMapping("/getProduct")
	public ResponseEntity<EcommerceResponse> getProduct(@RequestBody ProductDto productDto) {
		Product product = productServiceImp.getProduct(productDto);
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(product);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PutMapping("/updateProduct")
	public ResponseEntity<EcommerceResponse> updateProduct(@RequestBody ProductDto productDto) {
		productServiceImp.updateProduct(productDto);
		ecommerceResponse.setMessage("product modified successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteProduct")
	public ResponseEntity<EcommerceResponse> deleteProduct(@RequestBody ProductDto productDto) {
		productServiceImp.deleteProduct(productDto);
		ecommerceResponse.setMessage("Product Deleted successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/addCartItem")
	public ResponseEntity<EcommerceResponse> addCartItem(@RequestBody ProductDto productDto) {
		CartItem addCartItem = productServiceImp.addCartItem(productDto);
		ecommerceResponse.setMessage("cartItem added successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(addCartItem);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteCartItem")
	public ResponseEntity<EcommerceResponse> deleteCartItem(@RequestBody CartItemDto cartItemDto) {
		productServiceImp.deleteCartItem(cartItemDto);
		ecommerceResponse.setMessage("cartItem Deleted successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/createCart")
	public ResponseEntity<EcommerceResponse> createCart(@RequestBody Customer customer) {
		Double totalPrice = productServiceImp.createCart(customer);
		ecommerceResponse.setMessage("Cart created successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(totalPrice);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}

	@PostMapping("/createSalesOrder")
	public ResponseEntity<EcommerceResponse> createSalesOrder(@RequestBody CustomerDto customerDto) {
		customerServiceImp.createSalesOrder(customerDto);
		ecommerceResponse.setMessage("SalesOrder created successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}
	
	@PostMapping("/createRole")
	public ResponseEntity<EcommerceResponse> createRole(@RequestBody RoleDto roleDto) {
		adminServiceImp.createRole(roleDto);
		ecommerceResponse.setMessage("Role added successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}
	@DeleteMapping("/deleteRole")
	public ResponseEntity<EcommerceResponse> deleteRole(@RequestBody RoleDto roleDto) {
		boolean deleteRole = adminServiceImp.deleteRole(roleDto);
		ecommerceResponse.setMessage("Role deleted successfully");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}
}
