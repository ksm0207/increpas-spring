package spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BoardDAO;
import mybatis.vo.BoardVO;

@Controller
public class EditController {
	
	@Autowired
	private BoardDAO b_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext context;
	
	private String path = "/upload";
	private String ePath = "/editor_img";
	
	@RequestMapping("/edit.do")
	public ModelAndView showView(){
		String b_idx = request.getParameter("b_idx");
		
		ModelAndView mv = new ModelAndView();
		
		
		BoardVO vo = b_dao.getBbs(b_idx);
		
		mv.addObject("bbs",vo);
		
		mv.setViewName("edit");
		return mv;
	}
	
	@RequestMapping(value= "/edit.do", method = RequestMethod.POST)
	public ModelAndView edit(BoardVO vo,String cPage) throws IllegalStateException, IOException {
		
		ModelAndView mv = new ModelAndView();

		b_dao.editBbs(vo);
		
		
		mv.setViewName("redirect:board_view.do?b_idx="+vo.getB_idx() +"&cPage="+cPage);
		
		
		return mv;
	}

 
}
