package bbs.controller;

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

import editor.vo.ImgVO;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import spring.util.FileRenameUtil;

@Controller
public class WriteAction {

	@Autowired
	private BbsDAO b_dao;
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private HttpServletRequest request;
	
	private String img_path = "/editor_img";
	
	@RequestMapping("/write.inc") //get방식 요청시
	public String write() {
		return "write";
	}
	@RequestMapping(value="/write.inc", method = RequestMethod.POST)
	public ModelAndView add(BbsVO vo) throws IllegalStateException, IOException{
		
		ModelAndView mv = new ModelAndView();
		
		MultipartFile mf = vo.getFile();
		
		String realPath = application.getRealPath(img_path);
		String fname = mf.getOriginalFilename();
		
		mf.transferTo(new File(realPath,fname));
		
		vo.setFile_name(fname);
		vo.setOri_name(fname);
		vo.setIp(request.getRemoteAddr());
		
		/*
		int status = b_dao.add(vo);
		
		mv.addObject("add",status);
		mv.setViewName("write");
		*/
		
		return mv;
	}
	
	@RequestMapping(value="/saveImage.inc", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveImg(ImgVO vo){
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("SaveImage.inc");
		//넘어온 파일 검증
		MultipartFile f = vo.getS_file();
		String fname = null;
		
		if(f.getSize() > 0) {
			//첨부파일을 저장할 위치 - 절대경로화
			String realPath = application.getRealPath(img_path);
			
			fname = f.getOriginalFilename();
			System.out.println("getOriginalFilename: " + fname);
			
			// 첨부파일이 이미 저장된 파일 이름과 동일할 경우는 알아서
			// 체크해야 한다. - FileRenameUtil
			fname = FileRenameUtil.checkSameFileName(fname, realPath);
			System.out.println("FileRenameUtil : " + fname);
			try {
				// 업로드한 파일 데이터를 지정한 파일에 저장한다
				f.transferTo(new File(realPath, fname));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 비 동기식 요청한 곳으로 저장된 파일의 경로와 파일명을 보내야 한다.
		
		// 현재 서버 경로
		String path = request.getContextPath();
		
		map.put("path", path+img_path);
		map.put("fname", fname);
		
		return map; // map ------>  "path":"/editor_img",
					//			    "fname":"flag.png"
	}
	
	
}







