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
public class Seat {
	private int Seatid;
	@NotNull(message = "name can't be not null")
	@NotBlank(message = "name can't be not blank")
	private int noofseat;
	

}
