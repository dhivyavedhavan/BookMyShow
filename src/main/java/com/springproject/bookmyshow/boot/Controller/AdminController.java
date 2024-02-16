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
import com.springproject.bookmyshow.boot.dto.Admindto;
import com.springproject.bookmyshow.boot.entity.Admin;
import com.springproject.bookmyshow.boot.service.Adminservice;

@RestController
@RequestMapping("Admin")

public class AdminController {
	
	@Autowired
	Adminservice aService;
	
	@PostMapping("save")
	public  ResponseEntity<Responsestruture<Admindto>> saveAdmin(@RequestBody Admin admin)
	{
		return aService.saveAdmin(admin);
	}
	
	@GetMapping("find")
	public ResponseEntity<Responsestruture<Admindto>> findAdmin(@RequestParam int aId)
	{
		return aService.findAdmin(aId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Responsestruture<Admindto>> deleteAdmin(@RequestParam int aId,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return aService.deleteAdmin(aId, aEmail, aPassword);
	}
	
	@PutMapping("update")
	public ResponseEntity<Responsestruture<Admindto>> updateAdmin(@RequestBody Admin admin,@RequestParam int aId,@RequestParam String aEmail,@RequestParam String aPassword)
	{
		return aService.updateAdmin(admin, aId, aEmail, aPassword);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Responsestruture<List<Admindto>>> findAllAdmins()
	{
		return aService.findAllAdmin();
	}

}
