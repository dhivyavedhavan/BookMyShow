package com.springproject.bookmyshow.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.dao.Theaterdao;
import com.springproject.bookmyshow.boot.entity.Admin;
import com.springproject.bookmyshow.boot.entity.Theater;

@Service
public class Theaterservice {
	@Autowired
	Theaterdao tdao;
	
	@Autowired
	Admindao adao;
	
	public ResponseEntity<Responsestruture<Theater>> saveTheatre(Theater theatre ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Theater> str=new Responsestruture<Theater>();
			
			str.setMessage("Theatre has saved");
			str.setStatus(HttpStatus.CREATED.value());
			str.setData(tdao.saveTheater(theatre));
			
			return new ResponseEntity<Responsestruture<Theater>>(str,HttpStatus.CREATED);
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Theater>> findTheatre(int tId)
	{
		
		Responsestruture<Theater> str=new Responsestruture<Theater>();
		Theater t= tdao.findTheatre(tId);
		if(t!=null)
		{
			str.setMessage("Theatre has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(t);
			
			return new ResponseEntity<Responsestruture<Theater>>(str,HttpStatus.FOUND);
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Theater>> deleteTheatre(int tId ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Theater> str= new Responsestruture<Theater>();
			
			Theater t= tdao.findTheatre(tId);
			
			if(t!=null)
			{
				str.setMessage("Theatre has Deleted");
				str.setStatus(HttpStatus.OK.value());
				str.setData(tdao.deleteTheatre(tId));
				
				return new ResponseEntity<Responsestruture<Theater>>(str,HttpStatus.OK);
			}
			return null;
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Theater>> updateTheatre(Theater theatre,int tId ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Theater> str= new Responsestruture<Theater>();
			
			Theater t=tdao.findTheatre(tId);
			if(t!=null)
			{
				str.setMessage(" Theatre has updated");
				str.setStatus(HttpStatus.OK.value());
				str.setData(tdao.updatetheatre(theatre, tId));
				
				return new ResponseEntity<Responsestruture<Theater>>(str, HttpStatus.OK);
			}
			return null;
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<List<Theater>>> findAllTheatre()
	{
		List<Theater> tList=tdao.findAllTheatre();
		Responsestruture<List<Theater>> str= new Responsestruture<List<Theater>>();
		
		if(tList!=null)
		{
			str.setMessage("All Theatre are founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(tList);
			
			return new ResponseEntity<Responsestruture<List<Theater>>>(str,HttpStatus.FOUND);
			
		}
		return null;
	}
	

}
