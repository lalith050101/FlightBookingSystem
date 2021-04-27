package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "flightTicket")
public class FlightTicket {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
	
	@OneToOne
	private Flight flight;
	
	@Column
	private Long seatNo;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
    private int age;

	@Column
    private String gender;

	public FlightTicket() {
		
	}

	
	public FlightTicket(Long ticketId, Flight flight, Long seatNo, String firstName, String lastName, int age,
			String gender) {
		super();
		this.ticketId = ticketId;
		this.flight = flight;
		this.seatNo = seatNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}


	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Long getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Long seatNo) {
		this.seatNo = seatNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
