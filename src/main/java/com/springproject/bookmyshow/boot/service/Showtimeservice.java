package com.springproject.bookmyshow.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.dao.Showtimedao;
import com.springproject.bookmyshow.boot.entity.Admin;
import com.springproject.bookmyshow.boot.entity.Showtime;

@Service
public class Showtimeservice {
	@Autowired
	Showtimedao sdao;
	
	@Autowired
	Admindao adao;
	
	public ResponseEntity<Responsestruture<Showtime>> saveShows(Showtime shows ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Showtime> str=new Responsestruture<Showtime>();
			
			str.setMessage(" Show has added");
			str.setStatus(HttpStatus.CREATED.value());
			str.setData(sdao.saveShows(shows));
			
			return new ResponseEntity<Responsestruture<Showtime>>(str,HttpStatus.CREATED);
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Showtime>> findShows(int sId)
	{
		Responsestruture<Showtime> str=new Responsestruture<Showtime>();
		Showtime s= sdao.findShows(sId);
		if(s!=null)
		{
			str.setMessage("Shows has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(s);
			
			return new ResponseEntity<Responsestruture<Showtime>>(str,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Showtime>> deleteShows(int sId ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Showtime> str= new Responsestruture<Showtime>();
			
			Showtime s= sdao.findShows(sId);
			
			if(s!=null)
			{
				str.setMessage("Seat has Deleted");
				str.setStatus(HttpStatus.OK.value());
				str.setData(sdao.deleteShows(sId));
				
				return new ResponseEntity<Responsestruture<Showtime>>(str,HttpStatus.OK);
			}
			return null;
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Showtime>> updateShows(Showtime shows,int sId ,String aEmail,String aPassword)
	{
		Admin exa=adao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Showtime> str= new Responsestruture<Showtime>();
			
			Showtime s=sdao.findShows(sId);
			if(s!=null)
			{
				str.setMessage(" Seat has updated");
				str.setStatus(HttpStatus.OK.value());
				str.setData(sdao.updateShows(shows, sId));
				
				return new ResponseEntity<Responsestruture<Showtime>>(str, HttpStatus.OK);
			}
			return null;
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<List<Showtime>>> findAllShows()
	{
		List<Showtime> sList=sdao.findAllShows();
		Responsestruture<List<Showtime>> str= new Responsestruture<List<Showtime>>();
		
		if(sList!=null)
		{
			str.setMessage("All seats are founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(sList);
			
			return new ResponseEntity<Responsestruture<List<Showtime>>>(str,HttpStatus.FOUND);
			
		}
		return null;
	}

}
