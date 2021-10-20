package ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test4Action {
	
	@RequestMapping("/ex4.inc")
	public String ex4_form() {
		
		return "ex4";
	}
	
	@RequestMapping("/ex4_res.inc")
	public ModelAndView message(String msg) {
		System.out.println(msg);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("ex4_res");
		
		return mav;
	}

}
