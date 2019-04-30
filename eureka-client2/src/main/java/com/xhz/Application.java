package com.xhz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/hi/{name}")
	public String hi(@PathVariable String name) {
		return "[port:"+port+"] " + "hi "+name;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public String getUser(String userId) {
		return "[port:"+port+"] " + "{userId : " + userId + "}";
	}
	
}
