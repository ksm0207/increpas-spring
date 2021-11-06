package com.home.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.vo.MemVO;
import secure.sha256.SecureUtil;

@Controller
public class MemberController {
	
	@RequestMapping("/reg.do")
	public String memberRegistryView() {
		
		return "member/member_reg";
	}
	
	
	@RequestMapping(value= "/registry.do", method = RequestMethod.POST)
	public ModelAndView memberRegistry(MemVO vo) {
		
		ModelAndView mv = new ModelAndView();
		
		/*
			System.out.println(vo.getM_email());
			System.out.println(vo.getM_id());
			System.out.println(vo.getM_pw());
			System.out.println(vo.getM_name());
		*/
		
		String m_pw = vo.getM_pw();
		
		String salt = SecureUtil.generateSalt(); // salt 값
		String pwd = SecureUtil.getEncrypt(m_pw, salt);
		
		System.out.println("다이젝트 : "+pwd);
		
		vo.setM_pw(pwd);
		vo.setSalt_str(salt);
		
		// DAO : dao.add(vo);
		
		
		mv.addObject("vo",vo);
		mv.setViewName("redirect:/");
		
		
		return mv;
		
	}
	
	

}
