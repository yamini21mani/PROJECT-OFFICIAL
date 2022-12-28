package com.te.ecommerce.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BillingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String address;
	private String city;
	private String state;
	private Integer zipcode;
	private String country;
	
//	@OneToOne(mappedBy = "billingAddress")
//	private Customer customer;
//	@OneToOne(mappedBy = "billingAddress")
//	private SalesOrder salesOrder;
	
	
}
