package org.exam.task2.exception.handler;

import java.util.List;

import org.exam.task2.exception.message.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception handler to return error code 400 if a value of the request isn’t there. In response, should 
 * return the following JSON:
 * {
 * 	“message” : “{variable} is required”,
 * 	“status”: 400
 * }
 * 
 * @author Felipe Perez
 *
 */

@RestControllerAdvice
public class MissingRequestValueExceptionHandler {

	private final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleException(MethodArgumentNotValidException e) {
		
		ErrorMessage errorMessage = new ErrorMessage(getMessage(e), BAD_REQUEST.value());

		return new ResponseEntity<>(errorMessage, BAD_REQUEST);
	}

	/**
	 * 
	 * Get message from the fieldError
	 * 
	 * @param e
	 * @return
	 */
	private String getMessage(MethodArgumentNotValidException e) {
		BindingResult result = e.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		FieldError fieldError =  fieldErrors.stream().findFirst().get();
		
		return fieldError.getDefaultMessage();
	}

}
