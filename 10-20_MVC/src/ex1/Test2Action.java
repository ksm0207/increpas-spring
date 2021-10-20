package ex1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class Test2Action extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Ex2");

		mav.addObject("idx", "1");
		mav.addObject("name", "김성민");
		mav.addObject("age", "27");
		mav.addObject("email", "ksm03071@naver.com");
		mav.addObject("phone", "010-1234-5678");
		
		return mav;
	}

}
