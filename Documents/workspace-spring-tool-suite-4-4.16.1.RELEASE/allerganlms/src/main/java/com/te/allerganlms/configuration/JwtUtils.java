//package com.te.allerganlms.configuration;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtUtils {
//	@Value("${app.secret}")
//	private String secret;
//
//	public String generateToken() {
//		return Jwts.builder().setId("1").setSubject("ALLERGANLMS").setIssuer("ADMIN")
//				.signWith(SignatureAlgorithm.HS256, Base64Coder.encodeLines(secret.getBytes()))
//				.setExpiration(new Date()).compact();
//	}
//
//	public Claims getClaim() {
//		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(generateToken()).getBody();
//
//	}
//
//}
