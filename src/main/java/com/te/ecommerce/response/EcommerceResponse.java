package com.te.ecommerce.response;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class EcommerceResponse {
	private String message;
	private boolean error;
	private String status;
	private Object data;
}
