package com.te.ecommerce.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class UserDto {
	private Integer id;
	private String emailId;
	private String password;
	private String enabled;
}
