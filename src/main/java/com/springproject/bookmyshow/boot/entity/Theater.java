package com.springproject.bookmyshow.boot.entity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

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
public class Theater {
	private int Thearterid;
	@NotNull(message = "name can't be not null")
	@NotBlank(message = "name can't be not blank")
	private String Theartername;
	@NotNull(message = "name can't be not null")
	@NotBlank(message = "name can't be not blank")
	private String location;
	private double Capacity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Showtime tShowtime;
	
	public void setTId(int tid) {
		// TODO Auto-generated method stub
		
	}
	

}
