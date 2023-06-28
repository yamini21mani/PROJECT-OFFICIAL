package com.te.allerganlms.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FileDto {

	private String fileName;
	private String contentType;
	private String contents;

}
