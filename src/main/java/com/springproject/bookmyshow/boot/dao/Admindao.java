package com.springproject.bookmyshow.boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Adminrepo;
import com.springproject.bookmyshow.boot.entity.Admin;

@Repository

public class Admindao {
	@Autowired
	Adminrepo repo;
	
	public Admin saveadmin() {
		return repo.saveadmin();
	}
	public Admin findadmin(int adminId) {
		Optional<Admin>oadmin=repo.findById(adminId);
		if (oadmin.isPresent()) {
			return oadmin.get();	
		}
		return null;
	}
	public Admin deleteadmin(int adminId) {
		Admin admin=findadmin(adminId);
		repo.delete(admin);
		return admin;	
	}
	public Admin updateadmin(Admin admin,int adminId) {
		Admin exAdmin=findadmin(adminId);
		if (exAdmin!=null) {
			Admin.setAdminId(adminId);
			return repo.save(admin);
			
		}
		return null;
	}
}
