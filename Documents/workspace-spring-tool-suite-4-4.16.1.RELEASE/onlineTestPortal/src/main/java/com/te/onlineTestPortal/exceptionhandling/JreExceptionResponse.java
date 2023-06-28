package com.te.onlineTestPortal.exceptionhandling;

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
public class JreExceptionResponse {

	private String message;
}
