package com.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.dao.EmpDAO;
import com.mybatis.service.EmpService;
import com.mybatis.vo.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@RequestMapping("/emp_list.do")
	public ModelAndView showView() throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		EmpVO[] vo = service.all();
		
		mv.addObject("vo", vo);
		mv.setViewName("emp/emp_list");
		return mv;
		
	}
	
	@RequestMapping(value =  "/emp_view.do", method = RequestMethod.GET)
	public ModelAndView getEmployeeID(String empno) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		System.out.println(empno);
		
		EmpVO vo = service.searchEmpno(empno);
		mv.addObject("vo",vo);
		mv.setViewName("emp/emp_view");
		
		return mv;
	}

}
