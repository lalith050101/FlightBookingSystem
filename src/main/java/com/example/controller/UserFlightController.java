package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Flight;
import com.example.model.FlightTicket;
import com.example.model.Passenger;
import com.example.repository.FlightRepository;
import com.example.repository.FlightTicketRepository;
import com.example.repository.PassengerRepository;

@Controller
public class UserFlightController {

	@Autowired
    FlightRepository flightRepository;
	
	@Autowired
    PassengerRepository passengerRepository;
	
	@Autowired
    FlightTicketRepository flightTicketRepository;
	
	@RequestMapping(value = "/userFlights", method = RequestMethod.GET)
	public ModelAndView getAllFlights(ModelAndView mv) {
		
		 List<Flight> flights = flightRepository.findAllNotFullyFilled();
		 for(Flight flight: flights) {
			 int price = (int) flight.getPrice();
			 int percentageFilled = (int)((100*flight.getFilledSeats())/flight.getMaxSeats());
			 if(percentageFilled >90) {
				 flight.setPrice((long)(price*1.5));
			 }
			 else if(percentageFilled >50) {
				 flight.setPrice((long)(price*1.2));
			 }
		 }
         mv.addObject("flights", flights);
         mv.addObject("source", "");
         mv.addObject("destination", "");
         mv.setViewName("userFlights");
	     
	     return mv;
	 }
	
	@RequestMapping(value = "/searchFlights", method = RequestMethod.POST)
	public ModelAndView SearchFilghts(ModelAndView mv, @RequestParam("source") String source, @RequestParam("destination") String destination) {
		
		 List<Flight> flights = flightRepository.findAllBySourceAndDestination(source, destination);
		 mv.addObject("flights", flights);
        
         mv.setViewName("userFlights");
	     
	     return mv;
	 }
	
	
	@RequestMapping(value = "/bookFlight", method = RequestMethod.GET)
	public ModelAndView bookFlight( HttpServletRequest request) {
         ModelAndView mv = new ModelAndView();
         
         String code = request.getParameter("code");
	     Flight flight = flightRepository.findByCode(Long.parseLong(code)).orElse(null);
	     
         if(flight.getMaxSeats()-flight.getFilledSeats() == 0) {
        	 mv.setViewName("userFlights");
        	 return mv;
         }
         request.setAttribute("isEmpty", false);
         Passenger passenger = new Passenger();
         mv.addObject("passenger", passenger);
         mv.addObject("code", code);
         mv.addObject("flight", flight);
         mv.addObject("msg", "");
         mv.addObject("GrandTotal", "100");
         mv.setViewName("TicketBooking");
	     return mv;
	 }
	
	@RequestMapping(value = "/confirmTicket", method = RequestMethod.POST)
	public ModelAndView changePassengerCount( @ModelAttribute Passenger passenger, HttpServletRequest request) {
         ModelAndView mv = new ModelAndView();
         Long code = Long.parseLong(request.getParameter("code"));
         
         FlightTicket flightTicket = new FlightTicket();
         Flight flight = flightRepository.findByCode(code).orElse(null);
         flightTicket.setFlight(flight);
         flightTicket.setSeatNo((long) (flight.getFilledSeats()+1));
         flightTicket.setFirstName(passenger.getFirstName());
         flightTicket.setLastName(passenger.getLastName());
         flightTicket.setAge(passenger.getAge());
         flightTicket.setGender(passenger.getGender());
         
         if(flight.getMaxSeats()-flight.getFilledSeats() == 0) {
        	 mv.addObject("msg", "No seats Available");
        	 List<Flight> flights = flightRepository.findAllNotFullyFilled();
             mv.addObject("flights", flights);
        	 mv.setViewName("/userFlights");
        	 return mv;
         }
         
         flight.setFilledSeats(flight.getFilledSeats()+1);
         flightRepository.save(flight);
	     
         flightTicketRepository.save(flightTicket);
         
	     return new ModelAndView("redirect:/userFlights");
	 }
	
	@RequestMapping(value = "/myFlights", method = RequestMethod.GET)
	public ModelAndView getMyFlights() {
		ModelAndView mv = new ModelAndView();
		List<FlightTicket> flightTickets = flightTicketRepository.findAll();
         mv.addObject("flightsTickets", flightTickets);
         mv.addObject("source", "");

         mv.setViewName("myFlights");
	     
	     return mv;
	 }
	
	@RequestMapping(value = "/cancelFlightTicket", method = RequestMethod.GET)
	public ModelAndView cancelFlightTicket(@ModelAttribute FlightTicket flighTicket,BindingResult result, HttpServletRequest request) {
		
		flightTicketRepository.delete(flighTicket);; 
	     
	     return new ModelAndView("redirect:/myFlights");
	 }
	
}
