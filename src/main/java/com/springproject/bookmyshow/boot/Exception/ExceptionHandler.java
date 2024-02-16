package com.springproject.bookmyshow.boot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.springproject.bookmyshow.boot.Config.Responsestruture;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Stubbing;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> AdminNotFoundException(AdminNotFound ex){
		Responsestruture<String> structure=new Responsestruture<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Admin does not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(structure,HttpStatus.NOT_FOUND);
		}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> BookingNotFoundException(BookingNotFound ex){
		Responsestruture<String> struture=new Responsestruture<String>();
		struture.setData(ex.getMessage());
		struture.setMessage("Page not Found");
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> MovieNotFoundException(MovieNotFound ex){
		Responsestruture<String> structure=new Responsestruture<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Movie not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> SeatNotFoundException(SeatNotFound ex){
		Responsestruture<String> structure=new Responsestruture<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Seat Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> ShowNotFoundExcepton(ShowNotFound ex){
		Responsestruture<String> structure=new Responsestruture<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Showtime not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> TheaterNotFoundExcepyion(TheaterNotFound ex){
		Responsestruture<String> structure=new Responsestruture<String>();
		structure.setData(ex.getMessage());
		structure.setMessage("Theater not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> TicketNotFoundException(TicketNotFound ex){
		Responsestruture<String> struture=new Responsestruture<String>();
		struture.setData(ex.getMessage());
		struture.setMessage("Ticket Not Found");
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<Responsestruture<String>> UserNotFoundException(UserNotFound ex){
		Responsestruture<String> struture=new Responsestruture<String>();
		struture.setData(ex.getMessage());
		struture.setMessage("User Not Found");
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Responsestruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
