package com.app.Exception;

@SuppressWarnings("serial")
public class ResourceNotFound extends RuntimeException {
	
	public ResourceNotFound(String mesg) {
		super(mesg);
	}

}
