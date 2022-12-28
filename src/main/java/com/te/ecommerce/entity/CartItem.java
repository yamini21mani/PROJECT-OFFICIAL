package com.te.ecommerce.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Component
public class CartItem {
	@Id
	private Integer id;
	private Integer quantity;
	private double price;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	

}
