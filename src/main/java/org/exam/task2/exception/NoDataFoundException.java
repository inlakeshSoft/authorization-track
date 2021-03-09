package org.exam.task2.exception;

/**
 * Define NoDataFoundException in case a value searched wasn’t found.  
 * @author Felipe Perez
 *
 */
public class NoDataFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3496214174545488157L;

	private final static String AUTHORIZATION_NOT_FOUND = "Authorization not found";
	

	public NoDataFoundException() {
		super(AUTHORIZATION_NOT_FOUND);
	}
		
	public NoDataFoundException(Throwable cause) {
		super(AUTHORIZATION_NOT_FOUND, cause);
	}
}
