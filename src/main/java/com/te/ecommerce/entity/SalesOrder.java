package com.te.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Component
public class SalesOrder {
	@Id
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	private BillingAddress billingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
}
