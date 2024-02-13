package com.springproject.bookmyshow.boot.Config;

import lombok.Data;

@Data
public class Responsestruture<T> {
	
	private String message;
	private int status;
	private T data;

}
