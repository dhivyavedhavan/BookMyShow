package com.springproject.bookmyshow.boot.Exception;

public class TheaterNotFound extends RuntimeException{
	String message;

	public String getMessage() {
		return message;
	}

	public TheaterNotFound(String message) {
		this.message = message;

}
}
