package com.univ.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class StaffNotFoundException extends RuntimeException{
	
	
    public StaffNotFoundException(String message, Long staffId) {
    	super(message);
    }
    
    
}
