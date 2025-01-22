package com.example.spring.swagger.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {
	
	@Value("${message}")
	private String msg;
	
	@GetMapping("/hello")
	public String getHelloWorld() {
		return msg;
	}
	
	
	@Value("${messages : default value}")
	private String msg1;
	
	@GetMapping("/helloWorld")
	public String getDefaultValue() {
		return msg1;
	}
	
	@Value("${name-list}")
	private String[] msg2;
	
	
	@GetMapping("/nameList")
	public String[] getNameList() {
		return msg2;
	}
	
	@Value("#{${mapValues}}")
	private Map<String, Integer> testMap;
	
	@GetMapping("/mapList")
	public Map<String,Integer> getMapList(){
		return testMap;
	}
	

}
