package com.springproject.bookmyshow.boot.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.boot.entity.User;

public interface Userrepo extends JpaRepository<User, Integer> {

}
