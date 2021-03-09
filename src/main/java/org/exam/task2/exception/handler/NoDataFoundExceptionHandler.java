package org.exam.task2.exception.handler;

import org.exam.task2.exception.NoDataFoundException;
import org.exam.task2.exception.message.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * return error code 422 if a value searched wasn’t found. In response, 
 * should return the following JSON:
 * {
 *  “message” : “Authorization not found”,
 *   “status”: 422
 * }
 * 
 * @author Felipe Perez
 *
 */

@RestControllerAdvice
public class NoDataFoundExceptionHandler {

	private final HttpStatus UNPROCESSABLE_ENTITY = HttpStatus.UNPROCESSABLE_ENTITY;

	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<Object> handleException(NoDataFoundException e) {

		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), UNPROCESSABLE_ENTITY.value());

		return new ResponseEntity<>(errorMessage, UNPROCESSABLE_ENTITY);
	}

}
