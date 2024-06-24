package com.example.todo.TodoRestServices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.TodoRestServices.Bean.AuthenticationBean;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class BasicAuthendicationController {
	
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/hihello")
	public String HelloWorld() {
		return "hi hello";
	}
	
	@GetMapping(path = "/basicauth")
	public AuthenticationBean getHelloBean() {
		//throw new RuntimeException("some error has happned!contact support as ***-***");
		return new AuthenticationBean("your Authendicate");
	}

	
	
	@GetMapping(path = "/helloBean/path-variable/{name}")
	public AuthenticationBean getHelloBeanPathVariable(@PathVariable String name) {
		return new AuthenticationBean(String.format("hello bean, %s", name));
	}

	
	
//	@GetMapping(path="/helloBean/Path/{name}")
//   public HelloWorldBean getPathVeriabli(@PathVariable String name) {
//		
//		return new HelloWorldBean(String.format("hello, %S",name));
//   }
//	
	
	
	

}
