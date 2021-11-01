package com.example.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@RequestMapping("/login.do")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		System.out.println("MemberController ()");
		mv.setViewName("login");
		
		return mv;
	}

}
