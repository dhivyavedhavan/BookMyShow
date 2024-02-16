package com.springproject.bookmyshow.boot.Config;

import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.entity.Admin;

import lombok.Data;

@Data
public class Responsestruture<T> {
	
	private String message;
	private int status;
	private T data;


}
