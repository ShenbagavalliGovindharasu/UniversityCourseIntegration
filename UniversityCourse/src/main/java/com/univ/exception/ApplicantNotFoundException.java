package com.univapp.exception;

public class ApplicantNotFoundException extends RuntimeException{
	
	private String message;
	
	public ApplicantNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	public ApplicantNotFoundException() {
		
	}
}
