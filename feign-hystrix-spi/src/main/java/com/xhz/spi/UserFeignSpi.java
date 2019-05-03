package com.xhz.spi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xhz.spi.fail.UserFeignHystrix;

@FeignClient(value = "eureka-client", fallback = UserFeignHystrix.class)
public interface UserFeignSpi {

	@GetMapping("/hi/{name}")
	public String hi(@PathVariable(value="name") String name);
	
	@PostMapping(value = "/getUser")
	public String getUser(@RequestParam(value="userId") String userId);
	
}