package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Flight;
import com.example.repository.FlightRepository;


@Controller
public class FlightController {

	@Autowired
    FlightRepository flightRepository;
	
	@RequestMapping(value = "/flights", method = RequestMethod.GET)
	public ModelAndView getAllFlights(ModelAndView mv) {
		 List<Flight> flights = flightRepository.findAll();
         System.out.println("flights count"+flights.size());
         mv.addObject("flights", flights);
         mv.setViewName("flights");
	     
	     return mv;
	 }
	
	
	@RequestMapping(value = "/newFlightSchedule", method = RequestMethod.GET)
	public ModelAndView newFlight(ModelAndView model) {
	     Flight newFlight = new Flight();
	     model.addObject("flight", newFlight);
	     model.addObject("msg","Fill details of new Flight");
	     model.setViewName("flightForm");
	     return model;
	 }
	
	@RequestMapping(value = "/editFlightSchedule", method = RequestMethod.GET)
	public ModelAndView editFlight(ModelAndView model, HttpServletRequest request) {
		 String code = request.getParameter("code");
	     Flight flight = flightRepository.findByCode(Long.parseLong(code)).orElse(null);
	     model.addObject("flight", flight);
	     model.addObject("msg","Edit details of new Flight");
	     model.setViewName("editFlightForm");
	     return model;
	 }
	
	@RequestMapping(value = "/saveFlight", method = RequestMethod.POST)
	public ModelAndView addFlight(@ModelAttribute Flight flight,BindingResult result) {
	    
		 flightRepository.save(flight);
		 return new ModelAndView("redirect:/flights");
	 }
	
	@RequestMapping(value = "/updateFlight", method = RequestMethod.POST)
	public ModelAndView updateFlight(@ModelAttribute Flight flight,BindingResult result,HttpServletRequest request) {
		 System.out.println("flight code in update"+flight.getCode());
		 flightRepository.save(flight);
		 return new ModelAndView("redirect:/flights");
	 }
	
	@RequestMapping(value = "/deleteFlightSchedule", method = RequestMethod.GET)
	public ModelAndView deleteFlightSchedule(@ModelAttribute Flight flight,BindingResult result,HttpServletRequest request) {

		 System.out.println("flight delete"+flight.getCode());
		 flightRepository.delete(flight);
		 return new ModelAndView("redirect:/flights");
	 }
	 
}
