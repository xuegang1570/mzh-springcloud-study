package com.xhz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xhz.spi.UserRibbonSpi;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	@LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
	
	@Autowired
	private UserRibbonSpi userRibbonSpi;
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable String name) {
		return "[new is ribbon-hystrix]： " + userRibbonSpi.hi(name);
	}
	
	@GetMapping("/user/{userId}")
	public String getUser(@PathVariable String userId) {
		return "[new is ribbon-hystrix]： " + userRibbonSpi.getUser(userId);
	}
	
}