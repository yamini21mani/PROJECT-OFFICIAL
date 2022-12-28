package com.te.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
//	@NotBlank
	private String category;
//	@NotBlank
	private String description;
//	@NotBlank
	private String manufacturer;
//	@NotBlank
	private String name;
//	@NotBlank
	private double price;
	
//	private String unit;
	
//	@ManyToMany(cascade = CascadeType.ALL )
//	@JoinColumn(name = "product_id")
//	private List<CartItem> cartItem;
	
	@ManyToMany(cascade = CascadeType.ALL,targetEntity = CartItem.class)
	private List<CartItem> cartItem;
}
