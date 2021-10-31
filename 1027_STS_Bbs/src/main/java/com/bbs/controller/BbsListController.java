package com.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.util.Paging;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class BbsListController {
	
	@Autowired
	private BbsDAO b_dao;
	
	
	private String begin;
	private String end;
	
	private int nowPage;
	private int rowTotal;
	private final int BLOCKLIST = 5; // 한 페이지당 보여질 게시물 수
	private final int BLOCKPAGE = 5; // 한 페이지에 보여지는 블럭 수
	
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
		
		System.out.println("Bname :" + bname);
		
		// 페이징 처리
		Paging page = new Paging(nowPage, rowTotal, BLOCKLIST, BLOCKPAGE);
		
		rowTotal = b_dao.getBoardTotalCount(bname);
		
		begin = String.valueOf(page.getBegin());
		end = String.valueOf(page.getEnd());
		
		BbsVO[] vo =  b_dao.list(begin,end,bname);
		
		mv.addObject("bbs_list",vo);
		mv.addObject("rowTotal",rowTotal);
		mv.addObject("nowPage", nowPage);
		mv.addObject("blockList", BLOCKLIST);
		mv.addObject("page", page);
		
		mv.setViewName("bbs/bbs_list");
	
		return mv;
	}
	

}
