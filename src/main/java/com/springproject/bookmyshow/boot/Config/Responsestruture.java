package com.springproject.bookmyshow.boot.Config;

import java.util.List;

import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.entity.Admin;
import com.springproject.bookmyshow.boot.entity.Showtime;
import com.springproject.bookmyshow.boot.entity.Ticket;

import lombok.Data;

@Data
public class Responsestruture<T> {
	
	private String message;
	private int status;
	private T data;

}
