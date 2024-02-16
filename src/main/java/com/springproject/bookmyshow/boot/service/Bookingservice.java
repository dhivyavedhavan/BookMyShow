package com.springproject.bookmyshow.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Bookingdao;
import com.springproject.bookmyshow.boot.entity.Booking;
@Service
public class Bookingservice {
	@Autowired
	Bookingdao  bDao;
	
	public ResponseEntity<Responsestruture<Booking>> saveBooking(Booking booking)
	{
		Responsestruture<Booking> str = new Responsestruture<Booking>();
		
		str.setMessage("booking has done");
		str.setStatus(HttpStatus.CREATED.value());
		str.setData(bDao.saveBooking(booking));
		
		return new ResponseEntity<Responsestruture<Booking>>(str,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestruture<Booking>> findBooking(int bId)
	{
		Responsestruture<Booking> str= new Responsestruture<Booking>();
		
		Booking b=bDao.findBooking(bId);
		if(b!=null)
		{
			str.setMessage("Booking has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(b);
			return new ResponseEntity<Responsestruture<Booking>>(str,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Booking>> deleteBooking(int bId)
	{
		Responsestruture<Booking> str= new Responsestruture<Booking>();
		
		Booking b= bDao.findBooking(bId);
		if(b!=null)
		{
			str.setMessage("Booking has Deleted");
			str.setStatus(HttpStatus.OK.value());
			str.setData(bDao.deleteBooking(bId));
			
			return new ResponseEntity<Responsestruture<Booking>>(str,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Booking>> updateBooking(Booking booking,int bId)
	{
		Responsestruture<Booking> str=new  Responsestruture<Booking>();
		
		Booking b=bDao.findBooking(bId);
		if(b!=null)
		{
			str.setMessage("Booking has updated");
			str.setStatus(HttpStatus.OK.value());
			str.setData(bDao.updateBooking(booking, bId));
			
			return new ResponseEntity<Responsestruture<Booking>>(str, HttpStatus.OK);
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<List<Booking>>> findAllBoiking()
	{
		Responsestruture<List<Booking>> str=new Responsestruture<List<Booking>>();
		List<Booking> bList=bDao.findAllBooking();
		if(bList!=null)
		{
			str.setMessage("All Bookings are founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(bList);
			
			return new ResponseEntity<Responsestruture<List<Booking>>>(str,HttpStatus.FOUND);
		}
		return null;
	}

}
