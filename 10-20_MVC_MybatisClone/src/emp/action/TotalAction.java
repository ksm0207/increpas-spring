package emp.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

public class TotalAction {

	public TotalAction() {
		System.out.println("TotalAction");
	}
	
	@Autowired
	EmpDAO dao;
	
	@RequestMapping("/total.inc")
	public ModelAndView total() {
		
		ModelAndView mav = new ModelAndView();
		
		
		EmpVO[] total = dao.total();
		
		mav.addObject("total", total);
		mav.setViewName("emp/total");
		
		return mav;
	}
	
}
