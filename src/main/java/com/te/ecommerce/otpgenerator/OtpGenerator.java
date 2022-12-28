package com.te.ecommerce.otpgenerator;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class OtpGenerator {
	private final String INPUT="1234567890";
	private final Random RANDOM = new SecureRandom();
	public String generateRandomString(Integer length) {
		StringBuilder builder=new StringBuilder();
		
		for(int i=0;i<length;i++) {
			builder.append(INPUT.charAt(RANDOM.nextInt(INPUT.length())));
		}
		return builder.toString();
		
	}
public String getINPUT() {
		return INPUT;
	}
	public Random getRANDOM() {
		return RANDOM;
	}
}
