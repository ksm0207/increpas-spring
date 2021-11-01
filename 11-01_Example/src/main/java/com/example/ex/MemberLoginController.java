package com.example.ex;

import org.springframework.web.bind.annotation.RequestMapping;

public class MemberLoginController {
	
	@RequestMapping("/login")
	public String showView() {
		
		return "login";
	}

}
