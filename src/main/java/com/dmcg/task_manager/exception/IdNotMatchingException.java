package com.dmcg.task_manager.exception;

public class IdNotMatchingException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotMatchingException(String message) {
		super(message);
	}
}
