package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsListController {
	

	@RequestMapping("/list.do")
	public ModelAndView showList() {
		
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
