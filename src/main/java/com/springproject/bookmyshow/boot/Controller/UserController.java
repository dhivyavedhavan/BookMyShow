package com.springproject.bookmyshow.boot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dto.Userdto;
import com.springproject.bookmyshow.boot.entity.User;
import com.springproject.bookmyshow.boot.service.Userservice;

@RestController
@RequestMapping("User")
public class UserController {
	@Autowired
	Userservice uService;
	
	@PostMapping("save")
	public ResponseEntity<Responsestruture<Userdto>> saveUser(User user)
	{
		return uService.saveUser(user);
	}
	
	@GetMapping("find")
	public ResponseEntity<Responsestruture<Userdto>> findUser(int uId)
	{
		return uService.findUser(uId);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Responsestruture<Userdto>> delelteUser(int uId)
	{
		return uService.deleteUser(uId);
	}
	
	@PutMapping("update")
	public ResponseEntity<Responsestruture<Userdto>> updateUser(User user, int uId)
	{
		return uService.updateUser(user, uId);
	}
	
	@GetMapping("findAll")
	public ResponseEntity<Responsestruture<List<Userdto>>> findAllUsers()
	{
		return uService.findAllUser();
	}
	

}
