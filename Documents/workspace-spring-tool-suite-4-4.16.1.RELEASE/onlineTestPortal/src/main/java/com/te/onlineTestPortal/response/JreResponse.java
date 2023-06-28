package com.te.onlineTestPortal.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Component
public class JreResponse {

//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 7963074054003508106L;
	private String message;
	private Object data;
	private Integer error;

}
