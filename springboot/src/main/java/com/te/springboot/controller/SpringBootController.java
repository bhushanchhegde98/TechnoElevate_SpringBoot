package com.te.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SpringBootController {
	@GetMapping("/")
	public String firstHandlerMethod() {
		return "TechnoElevate";
	}

}
