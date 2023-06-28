package com.te.onlineTestPortal.response;

import java.util.List;
import java.util.Map;

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
@Setter
@Getter
public class DisplayQuestionsResponse {
	private String message;
	private List<String> key;
	private String subCode;
	private Integer error;
	private Map<String,List<String>> lists;
}
