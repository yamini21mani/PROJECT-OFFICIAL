package com.te.ecommerce.serviceinterface;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;

public interface ProductService {
	// product entity CRUD API's
	public boolean createProduct(ProductDto productDto);

	public Product getProduct(ProductDto productDto);

	public boolean updateProduct(ProductDto productDto);

	public boolean deleteProduct(ProductDto productDto);

	public CartItem addCartItem(ProductDto productDto);

	public void deleteCartItem(CartItemDto cartItemDto);

	public Double createCart(Customer customer);

}
