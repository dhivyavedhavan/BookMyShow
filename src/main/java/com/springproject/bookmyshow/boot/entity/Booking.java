package com.springproject.bookmyshow.boot.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
@Entity
@Component
@Getter
@Setter
public class Booking {
	
	public class Bookingdto {
		private int Bookingid;
		@Positive(message = "no of tickets can't be negative value")
		@Min(value = 1,message = "booking allowed minimum 1 ticket")
		@Max(value = 5,message = "booking allowed maximum 5 ticket only")
		private int nooftickets;
		@NotNull(message = "enter movie name")
		@NotBlank(message = "enter movie name")
		private double Bookingprice;
		private LocalDate bookingDate;
		
		@OneToMany(cascade = CascadeType.ALL)
		private Ticket bTicket;

	}

	public void setBId(int bId) {
		// TODO Auto-generated method stub
		
	}

}
