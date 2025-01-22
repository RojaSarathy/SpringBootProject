package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringbootcinfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcinfigserverApplication.class, args);
	}

}
