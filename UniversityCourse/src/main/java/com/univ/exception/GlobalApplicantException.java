package com.univ.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.univ.model.Applicant;

@ControllerAdvice

public class GlobalApplicantException {

	@ExceptionHandler
	public ResponseEntity handleException(Exception e) {
		Applicant applicant = new Applicant();
		applicant.setError("Something went wrong");
		applicant.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(applicant);
	}
}
