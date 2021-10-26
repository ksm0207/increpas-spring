package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BoardDAO;

@Controller
public class DelController {
	
	@Autowired
	private BoardDAO b_dao;
	
	
	@RequestMapping("/delete.do")
	public ModelAndView delBoard(String b_idx, String cPage) {
		
		System.out.println(b_idx);
		System.out.println(cPage);
		
		ModelAndView mv = new ModelAndView();
		
		
		b_dao.delBbs(b_idx); // status = 1
		
		mv.setViewName("redirect:/list.do?cPage="+cPage);
		
		return mv;
	}
	
	

}
