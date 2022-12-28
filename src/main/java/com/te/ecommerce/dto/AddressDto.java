package com.te.ecommerce.dto;


import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class AddressDto {
	private Integer id;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private String country;
}
