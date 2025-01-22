package com.example.spring.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class NameService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	
	
	public String callNameService() {
		
		CircuitBreaker cb = circuitBreakerFactory.create("nameService");
		
		return cb.run(() -> restTemplate.getForObject("http://localhost:8082/api/name",String.class) , Throwable -> fallBackService());
		
	//String name= restTemplate.getForObject("http://localhost:8082/api/name",String.class);
	//return name;
	
	}
	
	private String fallBackService() {
		
		return "Fall back name";
	}

	@Bean
	public RestTemplate reTemplate() {
		return new RestTemplate();
	}

}
