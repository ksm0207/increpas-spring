package com.Bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Bbs.Util.PageMarker;
import com.Bbs.dao.BbsDAO;
import com.Bbs.vo.BbsVO;

@Controller
public class BbsListController {
	
	@Autowired
	private BbsDAO bbs_dao;
	
	@Autowired
	private HttpServletRequest req;
	
	private String begin; 
	private String end;
	private int currentPage;
	private int bbsRowTotal;
	private int boardList = 5;
	private int pageBlock = 5;
	
	
	@RequestMapping("/list.do")
	public ModelAndView showView(String cPage, String bname) {

		ModelAndView mv = new ModelAndView();
		
		if(cPage == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(cPage);
		}
		
		if(bname == null) {
			bname = "BBS";
		}
		
		PageMarker page = new PageMarker(currentPage, bbsRowTotal, boardList, pageBlock);

		bbsRowTotal = bbs_dao.bbsTotal(bname);
		
		begin = String.valueOf(page.getBegin());
		end = String.valueOf(page.getEnd());
		
		BbsVO[] vo = bbs_dao.bbsList(begin, end, bname);
		
		mv.addObject("bbs", vo);
		mv.addObject("currentPage",currentPage);
		mv.addObject("bbsRowTotal",bbsRowTotal);
		mv.addObject("page",page);
		mv.addObject("boardList",boardList);
		mv.setViewName("bbs/bbs_list");
		
		return mv;
	}
	
	@RequestMapping(value = "/list.do",method = RequestMethod.POST)
	public ModelAndView searchView(String select, String search) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Select : "+select);
		System.out.println("Search : "+search);
		
		PageMarker page = new PageMarker(currentPage, bbsRowTotal, boardList, pageBlock);
		
		BbsVO[] vo = bbs_dao.bbsSearch(select, search);
		
		mv.addObject("bbs", vo);
		
		mv.addObject("bbsRowTotal",bbsRowTotal);
		mv.addObject("currentPage",currentPage);
		mv.addObject("boardList",boardList);
		mv.addObject("page",page);
		
		
		mv.setViewName("bbs/bbs_list");
		
		return mv;
	}

}
