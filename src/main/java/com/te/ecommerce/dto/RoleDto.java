package com.te.ecommerce.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class RoleDto {
	private Integer roleId;
	private String roleName;
}
