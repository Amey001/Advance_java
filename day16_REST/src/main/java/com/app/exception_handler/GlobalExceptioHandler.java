package com.app.exception_handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.app.dto.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custom_exceptions.ResourceNotFoundException;



//how to tell spring container ,following class is a spring bean,
//containing advice to all rest cotroller,
//regarding centralized exc. handling
//@ControllerAdvice +@ResponseBody -added impl on ret type of the methods
//we can use it in REST web Services


//this handler is providing common exc handling to all the 
@RestControllerAdvice //manditory
public class GlobalExceptioHandler {
//can obtain single/multiple exc handling methodss
//how to tell SC,following method: exc handling method
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
	{
		Map<String, String> map=e.getFieldErrors()
				.stream()
				.collect(Collectors.toMap(f->f.getField(),f->f.getDefaultMessage())); //list<FieldError>
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(e.getFieldError());
//		List<FieldError> getFieldErrors()
//		API of fielderror Class : getfiels :fiels name with err
//		getDefaultMessage : err msg
		
	}
	
	//add another exc handling method to handle resource not  found exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		System.out.println(" handles res not found !");
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponse(e.getMessage()));
	}
	
	//catch-all : H/W
	
	
	
}
