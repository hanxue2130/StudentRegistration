package com.mthree.exceptionhandling;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class StudentException extends RuntimeException {  
	public StudentException(String message) {
		super(message);
	}
}
