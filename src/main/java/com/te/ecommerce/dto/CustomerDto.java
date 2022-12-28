package com.te.ecommerce.dto;


import lombok.Data;
@Data

public class CustomerDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private long phoneno;
	private String email;
	private String password;
	private String otp;
}
