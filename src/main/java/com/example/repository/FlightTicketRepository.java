package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.FlightTicket;

@Repository
public interface FlightTicketRepository  extends JpaRepository<FlightTicket, Long>{

}
