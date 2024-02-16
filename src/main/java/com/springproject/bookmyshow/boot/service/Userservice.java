package com.springproject.bookmyshow.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Userdao;
import com.springproject.bookmyshow.boot.dto.Userdto;
import com.springproject.bookmyshow.boot.entity.User;

@Service
public class Userservice {
	@Autowired
	Userdao udao;
	
	Userdto uDto = new Userdto();
	ModelMapper mapper=new ModelMapper();
	
	public ResponseEntity<Responsestruture<Userdto>> saveUser(User user)
	{
		Responsestruture<Userdto> str = new Responsestruture<Userdto>();
		
		mapper.map(udao.saveUser(user), uDto);
		
		str.setMessage(user.getUsername()+"User has Saved");
		str.setStatus(HttpStatus.CREATED.value());
		str.setData(uDto);
		
		return new ResponseEntity<Responsestruture<Userdto>>(str,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<Responsestruture<Userdto>> findUser(int uId)
	{
		Responsestruture<Userdto> str= new Responsestruture<Userdto>();
		User u=udao.findUser(uId);
		if(u!=null)
		{
			mapper.map(u, uDto);
			
			str.setMessage(u.getUsername()+" user has founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(uDto);
			
			return new ResponseEntity<Responsestruture<Userdto>>(str,HttpStatus.FOUND);
			
		}
		return null;
	}
	
	public ResponseEntity<Responsestruture<Userdto>> deleteUser(int uId)
	{
		Responsestruture<Userdto> str= new Responsestruture<Userdto>();
		
		User u=udao.findUser(uId);
		if(u!=null)
		{
			mapper.map(udao.deleteUser(uId), uDto);
			
			str.setMessage(u.getUsername()+" user has deleted");
			str.setStatus(HttpStatus.OK.value());
			str.setData(uDto);
			
			return new ResponseEntity<Responsestruture<Userdto>>(str,HttpStatus.OK);
		}
		return null;
		
	}
	
	public ResponseEntity<Responsestruture<Userdto>> updateUser(User user, int uId)
	{
		
		Responsestruture<Userdto> str=new Responsestruture<Userdto>();
		
		User exu=udao.findUser(uId);
		if(exu!=null)
		{
			mapper.map(udao.updateUser(user, uId), uDto);
			
			str.setMessage(user.getUsername()+" user has updated");
			str.setStatus(HttpStatus.OK.value());
			str.setData(uDto);
			
			return new ResponseEntity<Responsestruture<Userdto>>(str,HttpStatus.OK);
		}
		return null;
	}
	
	
	public ResponseEntity<Responsestruture<List<Userdto>>> findAllUser()
	{
		List<User> uList=udao.findAllUser();
		List<Userdto> udList= new ArrayList<Userdto>();
		if(!uList.isEmpty())
		{
			for (User u : uList) {
				
				mapper.map(u, uDto);
				udList.add(uDto);
			}
			Responsestruture<List<Userdto>> str= new Responsestruture<List<Userdto>>();
			
			str.setMessage("All user's are founded");
			str.setStatus(HttpStatus.FOUND.value());
			str.setData(udList);
			
			return new ResponseEntity<Responsestruture<List<Userdto>>>(str,HttpStatus.FOUND);
			
		}
		return null;
	}

}
