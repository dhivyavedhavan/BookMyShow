package com.springproject.bookmyshow.boot.Exception;

public class SeatNotFound extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public SeatNotFound(String message) {
		this.message = message;

}
}
