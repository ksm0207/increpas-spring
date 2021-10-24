package bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class ListAction {

	@Autowired
	private BbsDAO b_dao;
	
	@RequestMapping("/list.inc")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		
		BbsVO[] ar = b_dao.getList(1, 10);
		mv.addObject("ar", ar);
		mv.setViewName("list");
		
		return mv;
	}
}
