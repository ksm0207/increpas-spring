package spring.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("PreHandle()");
		// 로그인 체크를 진행한다.
		
		// HttpServletRequest.getSession(boolean create)
		HttpSession session = request.getSession(true); // 요청과 연결된 현재 HttpSession을 반환하거나
                                                        // 현재 세션이 없고 만들기가 true 인 경우 새 세션을 반환합니다.		
                                                        // 새로운 세션을 만들려면 true를 만들고 현재 세션이 없으면 null을 반환한다.		
		
		// 로그인 시 저장했던 객체(mvo)를 얻어낸다.
		Object obj = session.getAttribute("mvo");
		
		if(obj == null) {
			// 로그인을 안한 상태
			System.out.println("Login X");
			response.sendRedirect("/login.do");
			return false;
		}
		return true;
	}

}
