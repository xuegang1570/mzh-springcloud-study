package com.xhz;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xhz.spi.UserFeignSpi;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //开启Feign的负载均衡功能
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Resource
	private UserFeignSpi userFeignSpi;
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable String name) {
		return "[new is feign]： " + userFeignSpi.hi(name);
	}
	
	@GetMapping("/user/{userId}")
	public String getUser(@PathVariable String userId) {
		return "[new is feign]： " + userFeignSpi.getUser(userId);
	}
	
}