package com.springproject.bookmyshow.boot.Exception;

import lombok.Getter;

@Getter
public class Loginfailed extends RuntimeException {

		String message;

		public Loginfailed(String message) {
			this.message = message;
		}
		
		

		
		

}
