package com.example.spring.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.swagger.model.AppConfig;

@RestController
public class AppConfigurationController {

	@Autowired
	AppConfig appConfig;
	
	@GetMapping("/appConfiguration")
	public String getAppConfig() {
		return appConfig.getHostName() + " "
				+appConfig.getPortNum() + " "
				+appConfig.getTimeOut();
	}
	
}
