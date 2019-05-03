package com.xhz.spi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRibbonSpi {

	@Autowired
    private RestTemplate restTemplate;
    
	@HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name){
        String result = this.restTemplate.getForObject("http://eureka-client/hi/" + name, String.class);
        return result;
    }

	@HystrixCommand(fallbackMethod = "getUserError")
    public String getUser(String userId){
    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    	params.add("userId", userId);
    	String result = this.restTemplate.postForObject("http://eureka-client/getUser", params, String.class);
        return result;
    }
	
	public String hiError(String name) {
        String result = "[Ribbon 熔断器] 服务已故障 ：" + name;
        return result;
    }
	
	public String getUserError(String userId) {
        String result = "[Ribbon 熔断器] 服务已故障 ：" + userId;
        return result;
    }
    
}