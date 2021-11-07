package com.home.app;

import java.io.IOException;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String mainView(Model model) throws IOException {
		
		// 외부 리소스 관리전용  컨테이너 생성
		GenericApplicationContext ctx = new GenericApplicationContext();
		
		// 환경변수 관리 객체 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		// 프로퍼티 관리 객체 생성
		MutablePropertySources props = env.getPropertySources();
		
		// 프로퍼티 관리 객체에 프로퍼티 파일 추가하기
		props.addLast(new ResourcePropertySource("classpath:/properties/api_key.properties"));
		
		String kakao_client = env.getProperty("kakao_client_id");
		String kakao_redirect = env.getProperty("kakao_redirect_uri");
		
		System.out.println("kakao_client :" + kakao_client);
		System.out.println("kakao_redirect :" + kakao_redirect);
		
		model.addAttribute("kakao_client",kakao_client);
		model.addAttribute("kakao_redirect",kakao_redirect);
		
		return "home";
	}

}
