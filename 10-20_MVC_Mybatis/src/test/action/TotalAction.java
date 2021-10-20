package test.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

public class TotalAction {

	@Autowired
	private EmpDAO e_dao;
	
	@RequestMapping("/total.inc")
	public ModelAndView total() {
		
		ModelAndView mav = new ModelAndView();
		
		EmpVO[] total = e_dao.search(null, null);
		
		mav.addObject("total", total);
		mav.setViewName("emp/total");
		return mav;
		
	}
}
