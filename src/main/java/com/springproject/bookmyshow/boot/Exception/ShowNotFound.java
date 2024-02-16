package com.springproject.bookmyshow.boot.Exception;

public class ShowNotFound extends RuntimeException{
	String message;

	public String getMessage() {
		return message;
	}

	public ShowNotFound(String message) {
		this.message = message;
	}
}
