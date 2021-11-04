package com.home.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsListController {
	
	@RequestMapping("/list.do")
	public ModelAndView showBbsListView() {
		
		ModelAndView mv = new ModelAndView();
		
		
		mv.setViewName("bbs/list");
		
		return mv;
	}
	
}
