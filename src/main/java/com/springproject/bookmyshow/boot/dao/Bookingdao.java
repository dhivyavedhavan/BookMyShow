package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Bookingrepo;
import com.springproject.bookmyshow.boot.entity.Booking;

@Repository
public class Bookingdao {
	@Autowired
	Bookingrepo bookRepo;
	
	public Booking saveBooking(Booking book)
	{
		return bookRepo.save(book);
	}
	
	public Booking findBokking(int bId)
	{
		Optional<Booking> opBooking=bookRepo.findById(bId);
		if(opBooking.isPresent())
		{
			return opBooking.get();
		}
		return null;
	}
	
	public Booking deleteBooking(int bId)
	{
		Booking b=findBokking(bId);
		bookRepo.delete(b);
		return b;
	}
	
	public Booking updateBooking(Booking book, int bId)
	{
		Booking exbook=findBokking(bId);
		if(exbook!=null)
		{
			book.setBId(bId);
			return bookRepo.save(book);
		}
		return null;
	}
	
	public List<Booking> findAllBooking()
	{
		List<Booking> book=bookRepo.findAll();
		return book;
	}
	

}
