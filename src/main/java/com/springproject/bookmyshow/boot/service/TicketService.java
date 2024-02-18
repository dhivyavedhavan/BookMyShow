package com.springproject.bookmyshow.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.Exception.Loginfailed;
import com.springproject.bookmyshow.boot.Exception.TicketNotFound;
import com.springproject.bookmyshow.boot.dao.Showtimedao;
import com.springproject.bookmyshow.boot.dao.Ticketdao;
import com.springproject.bookmyshow.boot.dao.Userdao;
import com.springproject.bookmyshow.boot.entity.Showtime;
import com.springproject.bookmyshow.boot.entity.Ticket;
import com.springproject.bookmyshow.boot.entity.User;

@Service
public class TicketService {
	@Autowired
	Ticketdao tdao;
	
	@Autowired
	Userdao udao;
	
	@Autowired
	Showtimedao sdao;
	
	public ResponseEntity<Responsestruture<Ticket>> saveTicket(Ticket ticket, String uEmail, String uPassword)
	{
		User exu=udao.userLogin(uEmail, uPassword);
		if(exu!=null)
		{
			Responsestruture<Ticket> str=new Responsestruture<Ticket>();
			
			str.setMessage("");
			str.setStatus(HttpStatus.CREATED.value());
			str.setData(ticket);
			
			return new ResponseEntity<Responsestruture<Ticket>>(str, HttpStatus.CREATED);
			
			
		}
		throw new Loginfailed("Enter the valid email and password");
	}
	
	public ResponseEntity<Responsestruture<Ticket>> findTicket(int tId)
	{
		
		Responsestruture<Ticket> str=new Responsestruture<Ticket>();
		Ticket t=tdao.findTicket(tId);
		if(t!=null)
		{
			str.setMessage("Ticket has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(t);
			
			return new ResponseEntity<Responsestruture<Ticket>>(str,HttpStatus.FOUND);
		}
		throw new TicketNotFound("Ticket not found with the given id"+tId);
		
	}
	
	public ResponseEntity<Responsestruture<Ticket>> deleteTicket(int tId, String uEmail,String uPassword)
	{
		User exu=udao.userLogin(uEmail, uPassword);
		if(exu!=null)
		{
			Responsestruture<Ticket> str=new Responsestruture<Ticket>();
			Ticket t=tdao.findTicket(tId);
			if(t!=null)
			{
				str.setMessage("ticket has deleted");
				str.setStatus(HttpStatus.OK.value());
				str.setData(tdao.deleteTicket(tId));
				
				return new ResponseEntity<Responsestruture<Ticket>>(str,HttpStatus.OK);
			}
			throw new TicketNotFound("Ticket not found with the given id"+tId);
		}
		throw new Loginfailed("Enter valid email & passworrd");
	}
	
	public ResponseEntity<Responsestruture<Ticket>> updateTicket(Ticket ticket ,int tId, String uEmail,String uPassword)
	{
		User exu=udao.userLogin(uEmail, uPassword);
		if(exu!=null)
		{
			Responsestruture<Ticket> str=new Responsestruture<Ticket>();
			if(ticket!=null)
			{
				str.setMessage("ticket has deleted");
				str.setStatus(HttpStatus.OK.value());
				str.setData(tdao.updateTicket(ticket, tId));
				
				return new ResponseEntity<Responsestruture<Ticket>>(str,HttpStatus.OK);
			}
			throw new TicketNotFound("Ticket not found with the given id"+tId);
		}
		throw new Loginfailed("Enter valid email & passworrd");
	}
	
	public ResponseEntity<Responsestruture<List<Ticket>>> findAllTicket()
	{
		Responsestruture<List<Ticket>> str=new Responsestruture<List<Ticket>>();
		List<Ticket> tList=tdao.findAllTicket();
		
		if(tList!=null)
		{
			str.setMessage("");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(tList);
			
			return new ResponseEntity<Responsestruture<List<Ticket>>>(str,HttpStatus.FOUND);
		}
		throw new TicketNotFound("Ticket not found ");
	}
	
	public ResponseEntity<Responsestruture<Ticket>> findShowbyTicket(int tId)
	{
		Responsestruture<Ticket> str= new Responsestruture<Ticket>();
		Ticket t =tdao.findTicket(tId);
		Showtime s= sdao.findShows((t.getTShows()).getSId());
		if(s!=null)
		{
			str.setMessage(null);
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(t);
			return new ResponseEntity<Responsestruture<Ticket>>(str, HttpStatus.FOUND);
		}
		
		
		return null;
	}

}
