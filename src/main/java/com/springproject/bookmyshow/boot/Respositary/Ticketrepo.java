package com.springproject.bookmyshow.boot.Respositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.bookmyshow.boot.entity.Ticket;

public interface Ticketrepo extends JpaRepository<Ticket, Integer>{

}
