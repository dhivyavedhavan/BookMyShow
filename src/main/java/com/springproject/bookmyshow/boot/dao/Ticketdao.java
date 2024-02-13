package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.springproject.bookmyshow.boot.Respositary.Ticketrepo;
import com.springproject.bookmyshow.boot.entity.Ticket;

public class Ticketdao {
	@Autowired
	Ticketrepo ticketrepo;
	
	public Ticket saveTicket(Ticket ticket)
	{
		return ticketrepo.save(ticket);
	}
	
	public Ticket findTicket(int tId)
	{
		Optional<Ticket> opticket=ticketrepo.findById(tId);
		if(opticket.isPresent())
		{
			return opticket.get();
		}
		return null;
	}
	
	public Ticket deleteTicket(int tId)
	{
		Ticket t=findTicket(tId);
		ticketrepo.delete(t);
		return t;
	}
	
	public Ticket updateTicket(Ticket ticket, int tId)
	{
		Ticket exticket=findTicket(tId);
		if(exticket!=null)
		{
			ticket.setTicketid(tId);
			return ticketrepo.save(ticket);
		}
		return null;
	}
	
	public List<Ticket> findAllTicket()
	{
		List<Ticket> ticket=ticketrepo.findAll();
		return ticket;
	}

}
