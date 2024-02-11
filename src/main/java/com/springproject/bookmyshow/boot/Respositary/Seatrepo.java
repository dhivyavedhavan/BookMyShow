package com.springproject.bookmyshow.boot.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.boot.entity.Seat;

public interface Seatrepo extends JpaRepository<Seat, Integer> {

}
