package com.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class BbsViewController {
	
	@Autowired
	private BbsDAO b_dao;
	
	
	@RequestMapping("/bbs_view.do")
	public ModelAndView showView(String b_idx) {
		
		ModelAndView mv = new ModelAndView();
		
		BbsVO vo = b_dao.getBbs(b_idx);
		
		mv.addObject("bbs",vo);
		mv.setViewName("bbs/bbs_view");
		
		return mv;
	}
}
