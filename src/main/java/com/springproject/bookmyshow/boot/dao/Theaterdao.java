package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Theaterrepo;
import com.springproject.bookmyshow.boot.entity.Theater;

@Repository
public class Theaterdao {
	@Autowired
	Theaterrepo theaterRepo;
	
	public Theaterrepo  saveTheatre(Theaterrepo theatre)
	{
		return theaterRepo.save(theatre);
	}
	
	public Theater findTheatre(int tId)
	{
		Optional<Theater> optheatre=theaterRepo.findById(tId);
		
		if(optheatre.isPresent())
		{
			return  optheatre.get();
		}
		return null;
	}
	
	public Theater deleteTheatre(int tId)
	{
		Theater t= findTheatre(tId);
		theaterRepo.delete(t);
		return t;
	}
	
	public Theater updatetheatre(Theater theatre,int tid)
	{
		Theater extheater=findTheatre(tid);
		if(extheater!=null)
		{
			theatre.setTId(tid);
			return theaterRepo.save(theatre);
		}
		return null;
	}
	
	public List<Theater> findAllTheatre()
	{
		List<Theater> theatre=theaterRepo.findAll();
		return theatre;
	}

}
