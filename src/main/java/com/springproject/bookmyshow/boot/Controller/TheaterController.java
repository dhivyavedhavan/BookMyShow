package com.springproject.bookmyshow.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.entity.Theater;
import com.springproject.bookmyshow.boot.service.Theaterservice;

@RestController
@RequestMapping("Theater")
public class TheaterController {
	@Autowired
	Theaterservice tService;
	
	@PostMapping("save")
	public ResponseEntity<Responsestruture<Theater>> saveTheatre(@RequestBody Theater theatre ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return tService.saveTheatre(theatre, aEmail, aPassword);
	}
	
	@GetMapping("find")
	public ResponseEntity<Responsestruture<Theater>> findTheatre(int tId)
	{
		return tService.findTheatre(tId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Responsestruture<Theater>> delelteTheatre(@RequestParam int tId ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return tService.deleteTheatre(tId, aEmail, aPassword);
	}
	
	@PutMapping("update")
	public ResponseEntity<Responsestruture<Theater>> updateShows(@RequestBody Theater theatre,@RequestParam int tId ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return tService.updateTheatre(theatre, tId, aEmail, aPassword);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Responsestruture<List<Theater>>> findAllShows()
	{
		return tService.findAllTheatre();
	}

}
