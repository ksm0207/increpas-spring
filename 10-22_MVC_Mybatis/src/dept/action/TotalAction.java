package dept.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.DeptDAO;
import mybatis.vo.DeptVO;

@Controller
public class TotalAction {

	@Autowired
	private DeptDAO dept_dao;
	
	@RequestMapping("/total.do")
	public ModelAndView total() {
		
		ModelAndView mv = new ModelAndView();
		
		DeptVO[] vo = dept_dao.getTotal();
		
		mv.addObject("total", vo);
		mv.setViewName("total");
		
		return mv;
	}
}
