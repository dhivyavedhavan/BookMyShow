package com.springproject.bookmyshow.boot.entity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Userid;
	@NotNull(message = "name can't be not null")
	@NotBlank(message = "name can't be not blank")
	private String Username;
	@NotNull(message = "password can't be not null")
	@NotBlank(message = "email can't be not blank")
	private String Usermail;
	@NotNull(message = "password can't be not null")
	@NotBlank(message = "password can't be not blank")
	@Email(message = "enter valid email (ex: abc@gmail.com)")
	@Size(min = 8, max = 20)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\\\S+$).{8,}$",
	message = "Your password must have at least minimum 8 charecter, 1 digit, 1 uppercase, 1 lowercase & 1 special charecter")
	private String Userpassword;
	private long UserContact;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Booking ubooking;
	


}
