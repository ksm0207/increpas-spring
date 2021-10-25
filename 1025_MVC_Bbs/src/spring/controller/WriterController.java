package spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BoardDAO;
import mybatis.vo.BoardVO;

@Controller
public class WriterController {
	
	@Autowired
	BoardDAO b_dao;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping("/write.do")
	public String showView() {
		return "write";
	}
	
	private String path = "/upload";
	
	@RequestMapping(value="/write.do",method = RequestMethod.POST)
	public ModelAndView add(BoardVO vo) throws IllegalStateException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		MultipartFile multipartFile = vo.getFile();
		
		String realPath = context.getRealPath(path);
		String upload_file = multipartFile.getOriginalFilename();
		
		multipartFile.transferTo(new File(realPath,upload_file));
		
		vo.setFile_name(upload_file);
		vo.setOri_name(upload_file);
		vo.setIp(request.getRemoteAddr());
		vo.setBname("BBS");
		
		int status = b_dao.add(vo);
		
		mv.addObject("status",status);
		mv.setViewName("list");
		
		return mv;
	}

}
