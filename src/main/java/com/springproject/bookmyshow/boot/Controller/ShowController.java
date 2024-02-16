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
import com.springproject.bookmyshow.boot.entity.Showtime;
import com.springproject.bookmyshow.boot.service.Showtimeservice;

@RestController
@RequestMapping("Showtime")
public class ShowController {
	
	@Autowired
	Showtimeservice sService;
	
	@PostMapping("save")
	public ResponseEntity<Responsestruture<Showtime>> saveShows(@RequestBody Showtime shows ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return sService.saveShows(shows, aEmail, aPassword);
	}
	
	@GetMapping("find")
	public ResponseEntity<Responsestruture<Showtime>> findShows(@RequestParam int sId)
	{
		return sService.findShows(sId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Responsestruture<Showtime>> delelteShows(@RequestParam int sId,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return sService.deleteShows(sId, aEmail, aPassword);
	}
	
	@PutMapping("update")
	public ResponseEntity<Responsestruture<Showtime>> updateShows(@RequestBody Showtime shows, @RequestParam int sId,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return sService.updateShows(shows, sId, aEmail, aPassword);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Responsestruture<List<Showtime>>> findAllShows()
	{
		return sService.findAllShows();
	}

}
