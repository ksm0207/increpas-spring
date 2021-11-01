package com.interceptor.app;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("login");
		
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public ModelAndView login(String id, String pw) {
		
		ModelAndView mv = new ModelAndView();
		
		session.setAttribute("mvo", id);
		
		mv.setViewName("main");
		
		return mv;
	}

}
