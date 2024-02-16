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
import com.springproject.bookmyshow.boot.entity.Seat;
import com.springproject.bookmyshow.boot.service.Seatservice;
@RestController
@RequestMapping("Seat")

public class SeatController {
	@Autowired
	Seatservice sService;

	@PostMapping("save")
	public ResponseEntity<Responsestruture<Seat>> saveSeats(@RequestBody Seat seats ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return sService.saveSeats(seats, aEmail, aPassword);
	}
	
	@GetMapping("find")
	public ResponseEntity<Responsestruture<Seat>> findSeats(int sId)
	{
		return sService.findSeats(sId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Responsestruture<Seat>> delelteSeats(@RequestParam int sId ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return sService.deleteSeats(sId, aEmail, aPassword);
	}
	
	@PutMapping("update")
	public ResponseEntity<Responsestruture<Seat>> updateSeats(@RequestBody Seat seats, @RequestParam int sId ,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return sService.updateSeats(seats, sId, aEmail, aPassword);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Responsestruture<List<Seat>>> findAllSeats()
	{
		return sService.findAllSeats();
	}

}
