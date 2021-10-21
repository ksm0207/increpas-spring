package spring.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.ImsiDAO;
import mybatis.vo.ImsiVO;

@Controller
public class WriteAction {

	@Autowired
	private ServletContext context;
	@Autowired
	private ImsiDAO dao;
	@Autowired
	HttpServletRequest request;
	
	//파일이 저장되는 위치 변수 선언
	private String uploadPath = "/upload";
	
	@RequestMapping("/write.do"  )
	public String write() {
		
		return "write";
	}
	
	// 똑같은 URL에 POST방식으로 요청할때 이곳에서 데이터를 처리한다.
	@RequestMapping(value="/write.do",method=RequestMethod.POST)
	public ModelAndView add(ImsiVO vo) {
		
		ModelAndView mv = new ModelAndView();
		
		// 첨부된 파일을 vo로부터 얻어낸다.
		MultipartFile mf = vo.getS_file();
		System.out.println("첨부파일 : " +mf);
		
		String realPath = context.getRealPath(uploadPath);
		
		String fname = mf.getOriginalFilename();
		
		try {
			mf.transferTo(new File(realPath,fname));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// DB에 저장할 파일명 지정
		vo.setFile_name(fname);
		
		System.out.println(vo.getContent());
		
		int status = dao.writeImsi(vo);
		
		mv.addObject("res",status);
		mv.setViewName("res");
		
		return mv;
	}
	
	
	
	
}
