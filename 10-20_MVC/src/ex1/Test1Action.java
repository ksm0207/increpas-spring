package ex1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

// AbsController : servlet_mvc 라이브러리 추가 후 생겨난 추상클래스.
public class Test1Action extends AbstractController {

	@Override              // 요청 내부 처리
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Controller 의해 호출된다.
		// 호출 할때는 특정 이름으로 등록되어 있어야함
		System.out.println("Test1Action () ");
		request.setAttribute("msg", "환영합니다.");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Ex1"); // for-ward할 경로, jsp 저장
		
		mav.addObject("str",1000); // K,V
		
		return mav;
	}

}
