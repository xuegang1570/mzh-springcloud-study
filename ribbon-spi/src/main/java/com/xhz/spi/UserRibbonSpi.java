package com.xhz.spi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRibbonSpi {

	@Autowired
    private RestTemplate restTemplate;
    
    public String hi(String name){
        String result = this.restTemplate.getForObject("http://eureka-client/hi/" + name, String.class);
        return result;
    }
    
    public String getUser(String userId){
    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    	params.add("userId", userId);
    	String result = this.restTemplate.postForObject("http://eureka-client/getUser", params, String.class);
        return result;
    }
    
}
