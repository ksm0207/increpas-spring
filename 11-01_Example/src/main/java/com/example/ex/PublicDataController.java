package com.example.ex;

import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicDataController {
	
	
	@RequestMapping("/data")
	public ModelAndView showView() {
	
		String path = "";
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
		
	}

}
