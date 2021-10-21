package spring.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxTestAction2 {

	@RequestMapping("/view1.do")
	public String testView() {
		
		return "view1";
	}
	
	@RequestMapping("/view1_res.do")
	@ResponseBody
	public ModelAndView testRes(String name , String password) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("name", name);
		mv.addObject("password",password);
		mv.setViewName("view1_res");
		System.out.println("Ajax : "+name + " / " + password);
		
		return mv;
	}
	
}
