package com.springproject.bookmyshow.boot.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Component
@Getter
@Setter
public class Booking {
	
	public class Bookingdto {
		private int Bookingid;
		private int nooftickets;
		private double Bookingprice;
		private LocalDate bookingDate;
		
		

	}

	public void setBId(int bId) {
		// TODO Auto-generated method stub
		
	}

}
