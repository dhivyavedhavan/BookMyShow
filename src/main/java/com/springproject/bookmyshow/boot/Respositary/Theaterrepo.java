package com.springproject.bookmyshow.boot.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.boot.entity.Theater;

public interface Theaterrepo extends JpaRepository<Theater, Integer>{

	Theaterrepo save(Theaterrepo theatre);

}
