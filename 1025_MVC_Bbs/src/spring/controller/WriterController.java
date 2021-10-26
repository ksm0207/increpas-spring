package spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BoardDAO;
import mybatis.vo.BoardVO;
import mybatis.vo.CommentVO;
import mybatis.vo.EditorImageVO;
import spring.util.FileRenameUtil;

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
	private String ePath = "/editor_img";
	
	@RequestMapping(value="/write.do",method = RequestMethod.POST)
	public ModelAndView add(BoardVO vo) throws IllegalStateException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		MultipartFile multipartFile = vo.getFile();
		
		String realPath = context.getRealPath(path);
		String upload_file = multipartFile.getOriginalFilename();
		
		if(multipartFile.getSize() > 0) {
			multipartFile.transferTo(new File(realPath,upload_file));
		}
		
		vo.setFile_name(upload_file);
		vo.setOri_name(upload_file);
		vo.setIp(request.getRemoteAddr());
		vo.setBname("BBS");
		b_dao.add(vo);
		mv.setViewName("redirect:/list.do");
		// redirect:/list.do
		return mv;
	}
	
	
	@RequestMapping(value="/saveImage.do",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> editImageFile(EditorImageVO vo) throws IllegalStateException, IOException{
		
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("Ajax");
		MultipartFile mtf = vo.getFile();
		System.out.println(mtf);
		String fname = null;
		
		if(mtf.getSize() > 0) {
			String realPath = context.getRealPath(ePath);
			fname = mtf.getOriginalFilename(); // XX.png
			fname = FileRenameUtil.checkSameFileName(fname, realPath); // return
			mtf.transferTo(new File(realPath,fname));
		}
		
		String cPath = context.getContextPath();
		
		map.put("path",cPath+ePath);
		map.put("fname",fname);
			
		return map;
	}
	
	@RequestMapping("/ans_write.do")
	public ModelAndView ans_write(CommentVO vo, String cPage) {
		
		ModelAndView mv = new ModelAndView();
		
	    b_dao.addAns(vo);
		
		mv.setViewName("redirect:/board_view.do?b_idx="+vo.getB_idx()+"&cPage="+cPage);
		return mv;
	}

}
