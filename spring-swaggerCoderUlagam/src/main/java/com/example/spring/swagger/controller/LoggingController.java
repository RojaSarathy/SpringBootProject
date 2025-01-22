package com.example.spring.swagger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
	
	Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@RequestMapping("/login")
	public String getLogin() {
		
		logger.debug("debug level logging");
		
		System.out.println(10/0);
		return "hello";
	}
}
