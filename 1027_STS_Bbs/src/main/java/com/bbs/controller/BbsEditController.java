package com.bbs.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class BbsEditController {
	
	@Autowired
	private BbsDAO b_dao;
	
	@Autowired
	private ServletContext context;
	
	String bbs_upload = "/resources/bbs_upload";
	
	@RequestMapping("/edit.do")
	public ModelAndView showView(String b_idx) {
		
		
		
		ModelAndView mv = new ModelAndView();
		
		BbsVO vo = b_dao.getBbs(b_idx);
		
		mv.addObject("bbs", vo);
		mv.setViewName("bbs/bbs_edit");
		
		return mv;	
	}
	
	@RequestMapping(value="/edit.do", method = RequestMethod.POST)
	public ModelAndView bbsUpdate(BbsVO vo, String cPage) throws IllegalStateException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		MultipartFile file = vo.getFile();
		
		// getOriginalFilename()
		// 클라이언트 파일 시스템의 원본 파일명을 반환한다
		String file_name = file.getOriginalFilename();
		String realPath = context.getRealPath(bbs_upload);
		
		if(file != null && file.getSize() > 0) {
			file.transferTo(new File(realPath,file_name));
		}
		
		vo.setFile_name(file_name);
		vo.setOri_name(file_name);
	
		System.out.println("PassWord : " + vo.getPwd());
		
		b_dao.bbsUpdate(vo);
		
		mv.setViewName("redirect:bbs_view.do?b_idx="+vo.getB_idx()+"&cPage="+cPage);
		
		return mv;
	}
	
}
