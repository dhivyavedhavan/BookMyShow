package com.springproject.bookmyshow.boot.entity;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Component
@Getter
@Setter
public class Showtime {
	private int Showtimeid;
	private LocalTime Starttime;
	private LocalTime Endtime;

}
