package com.app.Dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiResponse {
	private String message;
	
	public ApiResponse(String message) {
		super();
		this.message = message;
	}
}
