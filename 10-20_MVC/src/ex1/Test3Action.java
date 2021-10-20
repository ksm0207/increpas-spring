package ex1;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Test3Action implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		Date now = new Date(System.currentTimeMillis());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("now",now.toString());
		mav.setViewName("now");
		
		return mav;
	}

}
