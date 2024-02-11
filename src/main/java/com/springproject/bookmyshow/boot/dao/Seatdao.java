package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Seatrepo;
import com.springproject.bookmyshow.boot.entity.Seat;

@Repository
public class Seatdao {

	@Autowired
	Seatrepo seatRepo;
	
	public Seat saveSeats(Seat seats)
	{
		return seatRepo.save(seats);
	}
	
	public Seat findSeats(int sId)
	{
		Optional<Seat> opSeats=seatRepo.findById(sId);
		if(opSeats.isPresent())
		{
			return opSeats.get();
		}
		return null;
	}
	
	public Seat deleteSeats(int sId)
	{
		Seat s =findSeats(sId);
		seatRepo.delete(s);
		
		return s;
	}
	
	public Seat updateSeats(Seat seat,int sId)
	{
		Seat exs=findSeats(sId);
		
		if(exs!=null)
		{
			seat.setSeatid(sId);
			return seatRepo.save(seat);
		}
		return null;
	}
	
	public List<Seat> findAllSeats()
	{
		List<Seat> seats=seatRepo.findAll();
		return seats;
	}

}
