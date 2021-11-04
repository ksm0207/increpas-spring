package com.home.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Bbs.Util.PageMarker;
import com.Bbs.service.BbsUsingService;
import com.Bbs.vo.BbsVO;

@Controller
public class BbsListController {
	
	@Autowired
	private BbsUsingService bbs;
	
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
		
		bbsRowTotal =  bbs.bbsTotal(bname);
		
		begin = String.valueOf(page.getBegin());
		end = String.valueOf(page.getEnd());
		
		BbsVO[] vo = bbs.bbsList(begin, end, bname);
		
		mv.addObject("bbs", vo);
		mv.addObject("currentPage",currentPage);
		mv.addObject("bbsRowTotal",bbsRowTotal);
		mv.addObject("page",page);
		mv.addObject("boardList",boardList);
		mv.setViewName("bbs/bbs_list");
		
		return mv;
	}

}
