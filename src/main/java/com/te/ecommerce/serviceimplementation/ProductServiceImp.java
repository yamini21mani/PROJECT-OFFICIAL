package com.te.ecommerce.serviceimplementation;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.exceptionhandling.CartException;
import com.te.ecommerce.exceptionhandling.ProductException;
import com.te.ecommerce.repository.CartItemRepository;
import com.te.ecommerce.repository.CartRepository;
import com.te.ecommerce.repository.ProductRepository;
import com.te.ecommerce.serviceinterface.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private CartRepository cartRepository;

	@Override
	public boolean createProduct(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		productRepository.save(product);
		productRepository.findById(product.getId()).orElseThrow(() -> new ProductException("Unable to add product"));
		return true;

	}

	@Override
	public Product getProduct(ProductDto productDto) {
		Product product =new Product();
		BeanUtils.copyProperties(productDto, product);
		Product getProduct = productRepository.findById(product.getId())
				.orElseThrow(() -> new ProductException("No data found, please check the product ID"));
		return getProduct;
	}

	@Override
	public boolean updateProduct(ProductDto productDto) {
		Product product =new Product();
		BeanUtils.copyProperties(productDto, product);
		Product foundproduct = productRepository.findById(product.getId())
				.orElseThrow(() -> new ProductException("Please Check the product ID"));
//			if (productDto.getId() == foundproduct.getId()) {
//			BeanUtils.copyProperties(productDto, product);
		foundproduct.setName(productDto.getName());
		foundproduct.setCategory(productDto.getCategory());
		foundproduct.setPrice(productDto.getPrice());
		foundproduct.setDescription(productDto.getDescription());
		foundproduct.setManufacturer(productDto.getManufacturer());
		productRepository.save(product);
		return true;

	}

	@Override
	public boolean deleteProduct(ProductDto productDto) {
		Product product =new Product();
		BeanUtils.copyProperties(productDto, product);
		Product foundproduct = productRepository.findById(product.getId())
				.orElseThrow(() -> new ProductException("Unable to Delete the data, please check the Product ID"));
		productRepository.delete(foundproduct);
		return true;
	}

	@Override
	public CartItem addCartItem(ProductDto productDto) {
		Product product =new Product();
		BeanUtils.copyProperties(productDto, product);
		Product getProduct = productRepository.findById(product.getId()).orElse(null);
		
		CartItem cartItem = new CartItem();
		BeanUtils.copyProperties(getProduct, cartItem);
		
		cartItem.setId(productDto.getId());
		cartItem.setQuantity(productDto.getQuantity());
//		Cart cart=new Cart();
//		cartItem.setCart(cart);
		cartItem.setPrice(getProduct.getPrice() * productDto.getQuantity());
		CartItem save = cartItemRepository.save(cartItem);
		if (save != null)
			return save;
		else
			throw new CartException("unable to add Cart item");
	}

	@Override
	public void deleteCartItem(CartItemDto cartItemDto) {
		CartItem cartItem = new CartItem();
		BeanUtils.copyProperties(cartItemDto, cartItem);
		CartItem deleteCart = cartItemRepository.findById(cartItem.getId()).orElse(null);
		if (deleteCart != null)
			cartItemRepository.delete(deleteCart);
		else
			throw new CartException("Unable to delete cart item");
	}

	@Override
	public Double createCart(Customer customer) {
		Cart cart = new Cart();
		
//		CartItem cartItem=new CartItem();
//		Customer customer=new Customer();
//		CustomerRepository customerRepository;
		Double totalPrice = cartItemRepository.findAll().stream().collect(Collectors.summingDouble(p->p.getPrice()));
		cart.setTotalPrice(totalPrice);
		cartRepository.save(cart);

		return totalPrice;
	}

}
