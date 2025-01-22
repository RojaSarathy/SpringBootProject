package com.example.spring.swagger.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
public class AppConfig {
	
	private String hostName;
	
	private Integer portNum;
	
	private String timeOut;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Integer getPortNum() {
		return portNum;
	}

	public void setPortNum(Integer portNum) {
		this.portNum = portNum;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	
	
	

}
