package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Movierepo;
import com.springproject.bookmyshow.boot.entity.Movie;

@Repository
public class Moviedao {
	@Autowired
	Movierepo movierepo;
	
	public Movie saveMovie(Movie movie)
	{
		return movierepo.save(movie);
	}
	
	public Movie findMovie(int mId)
	{
		Optional<Movie> opMovie=movierepo.findById(mId);
		if(opMovie.isPresent())
		{
			return opMovie.get();
		}
		return null;
	}
	
	public Movie deleteMovie(int mId)
	{
		Movie m=findMovie(mId);
		movierepo.delete(m);
		return m;
	
	}
	
	public Movie updateMovie(Movie movie, int mId)
	{
		Movie exm=findMovie(mId);
		
		if(exm!=null)
		{
			movie.setMovieid(mId);
			return movierepo.save(movie);
		}
		return null;
	}
	
	public List<Movie> findAllMovie()
	{
		List<Movie> movie=movierepo.findAll();
		return movie;
	}

}
