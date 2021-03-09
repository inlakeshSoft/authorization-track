package org.exam.task2.exception.message;

/**
 * 
 * Defines the structure for custom error messages
 * 
 * message: error description 
 * status: error status code
 *  
 * @author Felipe Perez
 *
 */

public class ErrorMessage {

	private final String message;
	private final int status;

	public ErrorMessage(String message, int status) {
		this.message = message;
		this.status  = status;
	}
	
	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

}
