package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Showtimerepo;
import com.springproject.bookmyshow.boot.entity.Showtime;

@Repository
public class Showtimedao {
	@Autowired
	Showtimerepo showRepo;
	
	public Showtime saveShows(Showtime shows)
	{
		return showRepo.save(shows);
	}
	
	public Showtime findShows(int sId)
	{
		Optional<Showtime> opShow=showRepo.findById(sId);
		if(opShow.isPresent())
		{
			return opShow.get();
		}
		return null;
	}
	
	public Showtime deleteShows(int sId)
	{
		Showtime s=findShows(sId);
		showRepo.delete(s);
		
		return s;
	}
	
	public Showtime updateShows(Showtime shows, int sId)
	{
		Showtime exs=findShows(sId);
		if(exs!=null)
		{
			shows.setSId(sId);
			return showRepo.save(shows);
		}
		return null;
	}
	
	public List<Showtime> findAllShows()
	{
		List<Showtime> shows=showRepo.findAll();
		return shows;
	}

}
