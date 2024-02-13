package com.springproject.bookmyshow.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.springproject.bookmyshow.boot.Config.Responsestruture;
import com.springproject.bookmyshow.boot.dao.Admindao;
import com.springproject.bookmyshow.boot.entity.Admin;

public class Adminservice {
	@Autowired
	Admindao adao;
	
	public ResponseEntity<Responsestruture<Admin>> saveAdmin(Admin admin){
		Responsestruture<Admin> structure=new Responsestruture<Admin>();
		structure.setMessage("Save data sucess");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(adao.saveStudent(admin));
		return new ResponseEntity<Responsestruture<Admin>>(structure, HttpStatus.CREATED);
		
	}
	

}
