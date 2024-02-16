package com.springproject.bookmyshow.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.dao.Moviedao;
import com.springproject.bookmyshow.boot.entity.Admin;
import com.springproject.bookmyshow.boot.entity.Movie;

@Service
public class Movieservice {

	@Autowired
	Moviedao mDao;
	
	@Autowired
	Admindao aDao;
	
	public ResponseEntity<Responsestruture<Movie>> saveMovie(Movie movie ,String aEmail,String aPassword)
	{
		Admin exa=aDao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Movie> str=new Responsestruture<Movie>();
			
			str.setMessage(movie.getMovietitle()+" Movie has saved");
			str.setStatus(HttpStatus.CREATED.value());
			str.setData(mDao.saveMovie(movie));
			
			return new ResponseEntity<Responsestruture<Movie>>(str,HttpStatus.CREATED);
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Movie>> findMovie(int mId)
	{
		Responsestruture<Movie> str=new Responsestruture<Movie>();
		Movie m= mDao.findMovie(mId);
		if(m!=null)
		{
			str.setMessage(m.getMovietitle()+"Movie has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(m);
			
			return new ResponseEntity<Responsestruture<Movie>>(str,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Movie>> deleteMovie(int mId ,String aEmail,String aPassword)
	{
		Admin exa=aDao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Movie> str= new Responsestruture<Movie>();
			
			Movie m= mDao.findMovie(mId);
			
			if(m!=null)
			{
				str.setMessage(m.getMovietitle()+"Movie has Deleted");
				str.setStatus(HttpStatus.OK.value());
				str.setData(mDao.deleteMovie(mId));
				
				return new ResponseEntity<Responsestruture<Movie>>(str,HttpStatus.OK);
			}
			return null;
		}
		return null;
		
		
	}
	
	public ResponseEntity<Responsestruture<Movie>> updateMovie(Movie movie,int mId ,String aEmail,String aPassword)
	{
		Admin exa=aDao.adminLogin(aEmail, aPassword);
		if(exa!=null)
		{
			Responsestruture<Movie> str= new Responsestruture<Movie>();
			
			Movie m=mDao.findMovie(mId);
			if(m!=null)
			{
				str.setMessage(movie.getMovietitle()+" movie has updated");
				str.setStatus(HttpStatus.OK.value());
				str.setData(mDao.updateMovie(movie, mId));
				
				return new ResponseEntity<Responsestruture<Movie>>(str, HttpStatus.OK);
			}
			return null;
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<List<Movie>>> findAllMovies()
	{
		List<Movie> mList=mDao.findAllMovie();
		Responsestruture<List<Movie>> str= new Responsestruture<List<Movie>>();
		
		if(mList!=null)
		{
			str.setMessage("All movies are founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(mList);
			
			return new ResponseEntity<Responsestruture<List<Movie>>>(str,HttpStatus.FOUND);
			
		}
		return null;
	}

}
