package com.interceptor.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/main")
	public String first() {
		return "main";
	}
	
	@RequestMapping("/sub/bravo")
	public String bravo() {
		return "bravo";
	}

}
