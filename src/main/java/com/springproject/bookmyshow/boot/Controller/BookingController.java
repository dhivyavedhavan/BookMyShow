package com.springproject.bookmyshow.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.entity.Booking;
import com.springproject.bookmyshow.boot.service.Bookingservice;

public class BookingController {
	@Autowired
	Bookingservice bService;
	
	@PostMapping("save")
	public ResponseEntity<Responsestruture<Booking>> saveBooking(Booking booking)
	{
		return bService.saveBooking(booking);
	}
	
	@GetMapping("find")
	public ResponseEntity<Responsestruture<Booking>> findBooking(int bId)
	{
		return bService.findBooking(bId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Responsestruture<Booking>> delelteBooking(int bId)
	{
		return bService.deleteBooking(bId);
	}
	
	@PutMapping("update")
	public ResponseEntity<Responsestruture<Booking>> updateBooking(Booking booking, int bId)
	{
		return bService.updateBooking(booking, bId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Responsestruture<List<Booking>>> findAllBooking()
	{
		return bService.findAllBoiking();
	}

}
