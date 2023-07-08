package com.app.CustomException;


@SuppressWarnings("serial")
public class ResourceNotFoundExcept extends RuntimeException{
	
	public ResourceNotFoundExcept(String msg)
	{
		super(msg);
	}
}
