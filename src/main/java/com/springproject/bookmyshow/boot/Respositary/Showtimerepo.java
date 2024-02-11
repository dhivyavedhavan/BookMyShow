package com.springproject.bookmyshow.boot.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.boot.entity.Showtime;

public interface Showtimerepo extends JpaRepository<Showtime, Integer>{

}
