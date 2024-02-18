package com.springproject.bookmyshow.boot.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter

public class Ticket {
	private int ticketid;
	@NotNull(message = "name can't be not null")
	@NotBlank(message = "name can't be not blank")
	private int movieid;
	public Object getTShows() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
