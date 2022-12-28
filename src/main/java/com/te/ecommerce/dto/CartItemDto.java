package com.te.ecommerce.dto;


import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class CartItemDto {
	private Integer id;
	private Integer quantity;
	private double price;
}
