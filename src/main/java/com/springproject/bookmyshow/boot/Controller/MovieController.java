package com.springproject.bookmyshow.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.entity.Movie;
import com.springproject.bookmyshow.boot.service.Movieservice;

public class MovieController {
	@Autowired
	Movieservice mService;
	
	@PostMapping("save")
	public ResponseEntity<Responsestruture<Movie>> saveMovie(@RequestBody Movie movie ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return mService.saveMovie(movie, aEmail, aPassword);
	}
	
	@GetMapping("find")
	public ResponseEntity<Responsestruture<Movie>> findMovie(@RequestParam int mId)
	{
		return mService.findMovie(mId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Responsestruture<Movie>> delelteMovie(@RequestParam int mId ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return mService.deleteMovie(mId, aEmail, aPassword);
	}
	
	@PutMapping("update")
	public ResponseEntity<Responsestruture<Movie>> updateMovie(@RequestBody Movie movie,@RequestParam int mId ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return mService.updateMovie(movie, mId, aEmail, aPassword);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Responsestruture<List<Movie>>> findAllUsers()
	{
		return mService.findAllMovies();
	}

}
