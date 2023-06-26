package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter	//de-serialization
@Getter	//getting em n passw
@ToString	//only for debugging
//P.L validations

public class AuthRequestDTO {
	@NotBlank(message="Email cant't be blank")
	private String email;
	@NotBlank(message="password is req!")
	private String password;
}
