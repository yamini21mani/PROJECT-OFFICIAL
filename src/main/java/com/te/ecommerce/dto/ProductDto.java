package com.te.ecommerce.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class ProductDto {
	private Integer id;
	private String category;
	private String description;
	private String manufacturer;
	private String name;
	private double price;
	private Integer quantity;
//	private String unit;
}
