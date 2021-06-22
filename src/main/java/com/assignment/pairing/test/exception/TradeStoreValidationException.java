package com.assignment.pairing.test.exception;

import org.springframework.http.HttpStatus;

public class TradeStoreValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus code;
	private String message;

	public TradeStoreValidationException(HttpStatus code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TradeStoreValidationException [code=" + code + ", message=" + message + "]";
	}

}
