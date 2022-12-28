package com.te.ecommerce.dto;

import lombok.Data;

@Data
public class LoginDto {
private String email;
private String password;
private String otp;
private long phoneno;
}
