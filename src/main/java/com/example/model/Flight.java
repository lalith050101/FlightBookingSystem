package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "flight")
public class Flight {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column
    private String takeOffTime;

	@Column
    private long maxSeats;

	@Column
    private long price;
	
	@Column 
	private int filledSeats;

	
	public Flight() {
		
	}
	
	public Flight(Long code, String source, String destination, String takeOffTime, long maxSeats, long price,
			int filledSeats) {
		super();
		this.code = code;
		this.source = source;
		this.destination = destination;
		this.takeOffTime = takeOffTime;
		this.maxSeats = maxSeats;
		this.price = price;
		this.filledSeats = filledSeats;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public long getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(long maxSeats) {
		this.maxSeats = maxSeats;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getFilledSeats() {
		return filledSeats;
	}

	public void setFilledSeats(int filledSeats) {
		this.filledSeats = filledSeats;
	}
	
	
	
		
	

}
