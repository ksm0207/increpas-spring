package emp.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

public class ViewAction {
	
	@Autowired
	EmpDAO dao;
	
	public ViewAction() {
		System.out.println("ViewAction");
	}
	
	@RequestMapping("/view.inc")
	public ModelAndView view(String idx) {
		
		System.out.println(idx);
		ModelAndView mav = new ModelAndView();
		EmpVO view = dao.view(idx);
		
		mav.addObject("emp_view",view);
		mav.setViewName("emp/view");
		
		return mav;
	}
	
	
	
	
}
