package com.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;

@Controller
public class BbsDelController {

	@Autowired
	private BbsDAO b_dao;
	
	@RequestMapping("/del.do")
	public ModelAndView bbsDel(int b_idx, String cPage) {
		
		ModelAndView mv = new ModelAndView();
		
		b_dao.delBbs(b_idx);
		
		mv.setViewName("redirect:list.do?cPage="+cPage);
		
		return mv;	
	}
}
