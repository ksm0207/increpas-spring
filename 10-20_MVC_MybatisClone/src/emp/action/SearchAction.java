package emp.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

@Controller
public class SearchAction {

	public SearchAction() {
		System.out.println("SearchAction");
	}
	
	@Autowired
	EmpDAO dao;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/search.inc")
	public ModelAndView search() {
		
		String type = request.getParameter("type");
		String value = null;
		
		switch (type) {
		case "0":
			value = request.getParameter("s_empno");
			break;
			
		case "1":
			value = request.getParameter("s_name");
			break;	
			
		case "3":
			value = request.getParameter("s_job");
			break;		
		}
		
		System.out.println(type + " / " + value);
		ModelAndView mav = new ModelAndView();
		
		EmpVO[] search = dao.search(type, value);
		
		mav.addObject("search_res",search);
		mav.setViewName("emp/search_res");
		
		return mav;
		
	}
}
