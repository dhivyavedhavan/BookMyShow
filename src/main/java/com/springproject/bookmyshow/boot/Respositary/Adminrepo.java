package com.springproject.bookmyshow.boot.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.boot.entity.Admin;

public interface Adminrepo extends JpaRepository<Admin, Integer>{

	Admin saveadmin();

	Admin findadmin();

	Admin adminLogin(String aEmail, String aPassword);

}
