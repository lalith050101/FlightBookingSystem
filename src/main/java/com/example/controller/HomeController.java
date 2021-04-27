package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.LoginModel;

//@CrossOrigin(origins = "http://localhost:8081")
//@CrossOrigin(origins = "https://8081-dbdedffdadadeeffdaabdfaccfeebafecbf.examlyiopb.examly.io")
@CrossOrigin(origins = {"https://medworld.daranip.com","https://medworld.netlify.app"})
@Controller

public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {
		// /alien/{id} then use @PathVariable("id") int id
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", new LoginModel());
		mv.setViewName("login");
		
		return mv;
	}
}
