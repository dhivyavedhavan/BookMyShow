package com.springproject.bookmyshow.boot.entity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter
public class Theater {
	private int Thearterid;
	private String Theartername;
	private String location;
	private double Capacity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Showtime tShowtime;
	
	public void setTId(int tid) {
		// TODO Auto-generated method stub
		
	}
	

}
