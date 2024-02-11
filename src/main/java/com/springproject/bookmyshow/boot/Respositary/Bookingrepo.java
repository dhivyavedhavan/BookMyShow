package com.springproject.bookmyshow.boot.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.boot.entity.Booking;

public interface Bookingrepo extends JpaRepository<Booking, Integer>{

}
