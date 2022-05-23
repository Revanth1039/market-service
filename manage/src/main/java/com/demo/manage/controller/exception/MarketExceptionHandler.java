package com.demo.manage.controller.exception;

import java.util.ArrayList;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MarketExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MarketExceptionMessage.class)
	public ResponseEntity<Object> handleException(MarketExceptionMessage marketExceptionMessage) {
		return ResponseEntity.ok(marketExceptionMessage);

	}

	// Handle other invalid methods
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		MarketExceptionMessage marketExceptionMessage = new MarketExceptionMessage(String.valueOf(status.value()),
				"Method is not allowed");
		return new ResponseEntity<>(marketExceptionMessage, status);
	}

	// For handling post data with incorrect details ie: BadRequest
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		MarketExceptionMessage marketExceptionMessage = new MarketExceptionMessage(String.valueOf(status.value()),
				"Please Post Correct Details");
		return new ResponseEntity<>(marketExceptionMessage, status);
	}

	// For checking the constants of the attributes in controller layer
	@ExceptionHandler
	public ResponseEntity<Object> handle(ConstraintViolationException exception) {

		String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
		MarketExceptionMessage marketExceptionMessage = new MarketExceptionMessage("400", errorMessage);
		return new ResponseEntity<>(marketExceptionMessage, null, HttpStatus.BAD_REQUEST);
	}
}