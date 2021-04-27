package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.AuthenticationResponse;
import com.example.model.Flight;
import com.example.model.JwtModel;
import com.example.model.LoginModel;
import com.example.model.UserModel;
import com.example.repository.FlightRepository;
import com.example.repository.JwtRepository;
import com.example.repository.UserModelRepository;
import com.example.security.MyUserDetailsService;
import com.example.util.JwtUtil;

//@CrossOrigin(origins = "http://localhost:8081")
@CrossOrigin(origins = {"https://medworld.daranip.com","https://medworld.netlify.app"})
@Controller
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;
    
    @Autowired
    UserModelRepository userModelRepository;
    
    @Autowired
    FlightRepository flightRepository;
    
    @Autowired
    JwtRepository jwtRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView createAuthenticationToken(@ModelAttribute LoginModel loginModel) throws Exception {
        System.out.println("inside login 1");
        ModelAndView mv = new ModelAndView();
		
        try {
//        	 System.out.println("inside login 1.1");
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword())
//            );
//            
//            UserModel userModel = userModelRepository.findByEmail(loginModel.getEmail()).orElse(null);
//            
//            if(userModel==null) {
//            	System.out.println("inside login controller null");
//            }
//            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getEmail());
//            
//            final String jwt = jwtTokenUtil.generateToken(userDetails);
//            
//            JwtModel jwtModel = jwtRepository.findByToken(jwt).orElse(null); 
//            if(jwtModel != null) {
//            	jwtRepository.delete(jwtModel);
//            }
//        
        	 if(loginModel.getEmail().equals("admin") & loginModel.getPassword().equals("admin"))
        	 {
        		 return new ModelAndView("redirect:/flights");
        	 }
        	 else if(loginModel.getEmail().equals("user") & loginModel.getPassword().equals("user")) {
            return new ModelAndView("redirect:/userFlights");
        	 }
        	 else {
        		 return new ModelAndView("redirect:/");
        	 }
        }
        
       catch(Exception e) {
    	   mv.setViewName("login");
    	   return mv;
       }
       
    }
    
    @RequestMapping(value = "/userStatus", method = RequestMethod.GET)
    public ResponseEntity<AuthenticationResponse> getStatus(@RequestHeader(value="Authorization") String authorizationHeader)
    {
    	String jwt = authorizationHeader.substring(7);
        String username = jwtTokenUtil.extractUsername(jwt);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        UserModel userModel = userModelRepository.findByEmail(userDetails.getUsername()).orElse(null);
    	
        if(userModel == null) {
        	return ResponseEntity.ok(new AuthenticationResponse(null, true,false));
        }
        	System.out.print("isAdmin"+" "+userModel.getRole());
        boolean isAdmin = userModel.getRole().equals("admin");
    	return ResponseEntity.ok(new AuthenticationResponse(null, true,isAdmin));
    
	}

}









