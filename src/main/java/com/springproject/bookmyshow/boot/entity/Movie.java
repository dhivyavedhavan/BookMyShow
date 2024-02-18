package com.springproject.bookmyshow.boot.entity;

import java.time.LocalTime;

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
public class Movie {
	private int Movieid;
	@NotNull(message = "title can't be not null")
	@NotBlank(message = "title can't be not blank")
	private String Movietitle;
	@NotNull(message = "genre can't be not null")
	@NotBlank(message = "genre can't be not blank")
	private String Moviegenre;
	@Positive(message = "contact can't be negative value")
	@Min(value = 3,message = "ratting must start above 3 ")
	@Max(value = 10,message = "ratting must end before 10 ")
	private LocalTime movieduration;
	private int Rating;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Showtime mShowtime;

}
