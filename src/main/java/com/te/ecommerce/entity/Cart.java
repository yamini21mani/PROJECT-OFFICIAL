package com.te.ecommerce.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Component
public class Cart {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private double totalPrice;
	
//	@OneToOne(mappedBy = "cart")
//	private Customer customers;
//	@OneToMany(mappedBy = "cart")
//	private List<CartItem> cartItem;
//	@OneToOne(mappedBy = "c
//	private SalesOrder salesOrder;
	
}
