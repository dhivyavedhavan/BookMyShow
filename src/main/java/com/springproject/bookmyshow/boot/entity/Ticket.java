package com.springproject.bookmyshow.boot.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter

public class Ticket {
	private int ticketid;
	private int movieid;
	
	
	

}
