package com.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	//extra properties that you want to manage
	
	public ResourceNotFoundException()
	{
		super("RESOURCE NOT FOUND ON SERVER !!!");
	}

	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
