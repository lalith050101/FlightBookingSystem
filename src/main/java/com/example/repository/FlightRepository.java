package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	Optional<Flight> findByCode(long code);
	
	@Query(" from Flight where filledSeats < maxSeats")
	List<Flight> findAllNotFullyFilled();
	
	
	List<Flight> findAllBySourceAndDestination(String source, String destination);
}

