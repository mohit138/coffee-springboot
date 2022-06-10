package com.store.coffee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductExistsException.class)
	public ResponseEntity<Object> exception(ProductExistsException exception){
		return new ResponseEntity<>("Product Already Exists!", HttpStatus.NOT_ACCEPTABLE);
	}
}
