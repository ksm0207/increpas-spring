package com.home.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyDiskController {
	
	@RequestMapping("/disk.do")
	public ModelAndView showView() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("disk");
		
		return mv;
	}

}
