package com.example.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieReservation {
	
	@RequestMapping("/reservation")
	public String showView() {
	        
		return "reservation";
	}

}
