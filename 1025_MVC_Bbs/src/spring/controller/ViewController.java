package spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import mybatis.dao.BoardDAO;
import mybatis.vo.BoardVO;

@Controller
public class ViewController {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	BoardDAO b_dao;
	
	
	@RequestMapping("/board_view.do")
	public String showView() {
		
		return "board_view";
	}
	
	@RequestMapping(value="/board_view.do",method = RequestMethod.GET)
	public ModelAndView getBoardViewData() {
		
		ModelAndView mv = new ModelAndView();

		String cPage = request.getParameter("cPage");
		String b_idx = request.getParameter("b_idx");
		
		System.out.println(cPage);
		System.out.println(b_idx);
		BoardVO bbs = b_dao.getBbs(b_idx);
		
		mv.addObject("bbs",bbs);
		mv.setViewName("board_view");
		
		return mv;
	}

}
