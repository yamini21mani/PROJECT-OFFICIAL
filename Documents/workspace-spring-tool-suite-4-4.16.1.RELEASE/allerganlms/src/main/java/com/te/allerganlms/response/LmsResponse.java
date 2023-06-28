package com.te.allerganlms.response;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LmsResponse {
	private String message;
	private boolean error;
	private Object data;
	private List<Object> dataList;
}
