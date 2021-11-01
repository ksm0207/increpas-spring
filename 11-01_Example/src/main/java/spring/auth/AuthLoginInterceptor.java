package spring.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle()");
		
		HttpSession session = request.getSession(true);
		
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
