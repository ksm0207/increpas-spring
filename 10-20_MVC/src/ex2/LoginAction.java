package ex2;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {

	// 세션저장하는법.
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login.inc")
	public String loginView() {
		
		return "login";
	}
	
	/*
	@RequestMapping("/login_res.inc")
	public ModelAndView login(String id, String pw) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("id",id);
		mav.addObject("pw",pw);
		mav.setViewName("login_res");
		
		return mav;
	}
	*/
	
	@RequestMapping("/login_res.inc")
	public ModelAndView login(LoginVO vo) {
		
		ModelAndView mav = new ModelAndView();
		
		// mav.addObject("vo",vo);
		// mav.setViewName("user/ex5_login_res"); WEB-INF/jsp/user/ex5_login.jsp

		session.setAttribute("vo", vo);
		mav.setViewName("user/ex5_login.res");
		return mav;
	}
	
}
