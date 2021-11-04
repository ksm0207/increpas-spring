package com.home.test.bean;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect // 관점프로그래밍 선언
@Component
public class AspectBean {
	
	@Autowired
	private HttpServletRequest req;
	
	// 패키지안에 모든 객체들의 모든 메소드가 실행될때
/*
	@Pointcut("execution(* com.home.test.*.*(..))")
	private void myPointcut() {
		// 실행 1
	}
*/
	@Pointcut("execution(* com.home.test.MyDiskController.*(..)) ")
	private void myPointcut() {
		
	}
	 // 코드 삽입
	@Around("myPointcut()")
	public Object checkTime(ProceedingJoinPoint pjp) throws Throwable{
	
		long startTime = System.nanoTime();
		
		req.setAttribute("url", req.getRequestURI());
		
		Object retVal = pjp.proceed();
		
		long endTime = System.nanoTime();
		
		req.setAttribute("time", endTime - startTime);
		
		return retVal;
		
	}
}
