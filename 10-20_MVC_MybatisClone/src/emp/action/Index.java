package emp.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class Index {
	
	@RequestMapping("/*.inc")
	public ModelAndView main_view() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

}
