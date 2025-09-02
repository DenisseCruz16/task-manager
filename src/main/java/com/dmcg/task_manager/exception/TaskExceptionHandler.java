package com.dmcg.task_manager.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskExceptionHandler {
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<String>("Invalid input: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(exception = NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        return new ResponseEntity<String>("Invalid ID: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(exception = IdNotMatchingException.class)
	public ResponseEntity<String> hadleIdNotMatchingException(IdNotMatchingException ex){
		return new ResponseEntity<String>("Invalid input: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(exception = IllegalArgumentException.class)
	public ResponseEntity<String> hadleIllegalArgumentException(IllegalArgumentException ex){
		return new ResponseEntity<String>("Invalid input: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
