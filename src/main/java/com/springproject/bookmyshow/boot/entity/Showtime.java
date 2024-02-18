package com.springproject.bookmyshow.boot.entity;

import java.time.LocalTime;

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
public class Showtime {
	private int Showtimeid;
	@NotNull(message = "name can't be not null")
	@NotBlank(message = "name can't be not blank")
	private LocalTime Starttime;
	private LocalTime Endtime;
	public void setSId(int sId) {
		// TODO Auto-generated method stub
		
	}

}
