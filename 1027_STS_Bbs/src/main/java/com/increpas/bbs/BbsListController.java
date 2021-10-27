package com.increpas.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class BbsListController {
	
	@Autowired
	private BbsDAO b_dao;
	
	
	int nowPage = 0;
	
	@RequestMapping("/list.do")
	public ModelAndView showView(String cPage, String bname) {
		ModelAndView mv = new ModelAndView();
		
		if(cPage == null) {
			nowPage = 1;
		}else {
			nowPage = Integer.parseInt(cPage);
		}
		
		if(bname == null) {
			bname = "BBS";
		}
		
		// 페이징 처리
		
		BbsVO[] vo =  b_dao.list("1", "10", bname);
		
		mv.addObject("bbs_list",vo);
		mv.setViewName("bbs_list");
	
		return mv;
	}
	

}
