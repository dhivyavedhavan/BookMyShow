package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Userrepo;
import com.springproject.bookmyshow.boot.entity.User;

@Repository
public class Userdao {
	@Autowired
	Userrepo uRepo;
	
	public User saveUser(User user)
	{
		return uRepo.save(user);
	}
	
	
	public User findUser(int uId)
	{
		Optional<User> opUser= uRepo.findById(uId);
		if(opUser.isPresent())
		{
			return opUser.get();
		}
		return null;
	}
	
	public User deleteUser(int uId)
	{
		User u = findUser(uId);
		uRepo.delete(u);
		return u;
		
	}
	
	public User updateUser(User user, int uId)
	{
		User exu= findUser(uId);
		
		if(exu!= null)
		{
			user.setUserid(uId);
			return uRepo.save(user);
		}
		return null;
	}
	
	public List<User> findAllUser()
	{
		List<User> user=uRepo.findAll();
		return user;
	}


	public User userLogin(String uEmail, String uPassword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

