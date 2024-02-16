package com.springproject.bookmyshow.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.dao.Seatdao;
import com.springproject.bookmyshow.boot.entity.Admin;
import com.springproject.bookmyshow.boot.entity.Seat;

@Service
public class Seatservice {
	@Autowired
	Seatdao sdao;
	
	@Autowired
	Admindao adao;
	
	public ResponseEntity<Responsestruture<Seat>> saveSeats(Seat seats ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Seat> str=new Responsestruture<Seat>();
			
			str.setMessage(" seat has added");
			str.setStatus(HttpStatus.CREATED.value());
			str.setData(sdao.saveSeats(seats));
			
			return new ResponseEntity<Responsestruture<Seat>>(str,HttpStatus.CREATED);
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Seat>> findSeats(int sId )
	{
		Responsestruture<Seat> str=new Responsestruture<Seat>();
		Seat s= sdao.findSeats(sId);
		if(s!=null)
		{
			str.setMessage("Seats has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(s);
			
			return new ResponseEntity<Responsestruture<Seat>>(str,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Seat>> deleteSeats(int sId ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Seat> str= new Responsestruture<Seat>();
			
			Seat s= sdao.findSeats(sId);
			
			if(s!=null)
			{
				str.setMessage("Seat has Deleted");
				str.setStatus(HttpStatus.OK.value());
				str.setData(sdao.deleteSeats(sId));
				
				return new ResponseEntity<Responsestruture<Seat>>(str,HttpStatus.OK);
			}
			return null;
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Seat>> updateSeats(Seat seats,int sId ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Seat> str= new Responsestruture<Seat>();
			
			Seat s=sdao.findSeats(sId);
			if(s!=null)
			{
				str.setMessage(" Seat has updated");
				str.setStatus(HttpStatus.OK.value());
				str.setData(sdao.updateSeats(seats, sId));
				
				return new ResponseEntity<Responsestruture<Seat>>(str, HttpStatus.OK);
			}
			return null;
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<List<Seat>>> findAllSeats()
	{
		List<Seat> sList=sdao.findAllSeats();
		Responsestruture<List<Seat>> str= new Responsestruture<List<Seat>>();
		
		if(sList!=null)
		{
			str.setMessage("All seats are founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(sList);
			
			return new ResponseEntity<Responsestruture<List<Seat>>>(str,HttpStatus.FOUND);
			
		}
		return null;
	}

}
