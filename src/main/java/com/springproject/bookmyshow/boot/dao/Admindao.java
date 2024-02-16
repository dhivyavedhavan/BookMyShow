package com.springproject.bookmyshow.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproject.bookmyshow.boot.Respositary.Adminrepo;
import com.springproject.bookmyshow.boot.entity.Admin;

@Repository

public class Admindao {
	@Autowired
	Adminrepo arepo;
	
	public Admin saveadmin() {
		return arepo.saveadmin();
	}
	public Admin findadmin(int adminId) {
		Optional<Admin>oadmin=arepo.findById(adminId);
		if (oadmin.isPresent()) {
			return oadmin.get();	
		}
		return null;
	}
	public Admin deleteadmin(int adminId) {
		Admin admin=findadmin(adminId);
		arepo.delete(admin);
		return admin;	
	}
	public Admin updateadmin(Admin admin,int adminId) {
		Admin exAdmin=findadmin(adminId);
		if (exAdmin!=null) {
			Admin.setAdminId(adminId);
			return arepo.save(admin);
			
		}
		return null;
	}
	public Admin saveStudent(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}
     public Admin adminLogin(String aEmail,String aPassword) {
		
		return arepo.adminLogin(aEmail, aPassword);
	}
	public List<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		return null;
	}
}
