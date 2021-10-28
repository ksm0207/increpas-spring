package com.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.util.FileRenameUtil;
import com.spring.vo.ImgVO;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class BbsWriteController {
	
	@Autowired
	private BbsDAO b_dao;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	HttpServletRequest req;
	
	private String editor_img = "/resources/editor_img";
	private String bbs_upload = "/resources/bbs_upload";
	
	@RequestMapping("/write.do")
	public String showView() {
		
		return "bbs/bbs_write";
	}
	
	@RequestMapping(value="/write.do", method = RequestMethod.POST)
	public ModelAndView doAdd(BbsVO vo) throws IllegalStateException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		MultipartFile file = vo.getFile();
		
		String realPath = context.getRealPath(bbs_upload);
		String file_name = file.getOriginalFilename();
		
		
		if(file.getSize() != 0 && file_name != null) {
			file.transferTo(new File(realPath,file_name)); // 경로,파일 저장
		}
		
		vo.setFile_name(file_name);
		vo.setOri_name(file_name);
		vo.setIp(req.getRemoteAddr());
		vo.setBname("BBS");
		
		b_dao.add(vo);
		
		mv.setViewName("redirect:list.do");
		
		
		return mv;
	}
	
	@RequestMapping(value ="/saveImage.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveEditImg(ImgVO vo) throws IllegalStateException, IOException{
		
		Map<String, String> map = new HashMap<String, String>();
		
		MultipartFile mtf = vo.getFile();
		
		String fname = null;
		
		if(mtf.getSize() > 0) {
			String realPath = context.getRealPath(editor_img);
			fname = mtf.getOriginalFilename();
			fname = FileRenameUtil.checkSameFileName(fname, realPath);
			mtf.transferTo(new File(realPath,fname));
		}
		
		String cPath = context.getContextPath();
		System.out.println(cPath+System.getProperty("file.separator")+editor_img);
		
		map.put("path", cPath+editor_img);
		map.put("fname", fname);
		
		return map;
	}

}
