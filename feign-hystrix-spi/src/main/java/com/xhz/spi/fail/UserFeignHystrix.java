package com.xhz.spi.fail;

import org.springframework.stereotype.Component;

import com.xhz.spi.UserFeignSpi;

@Component
public class UserFeignHystrix implements UserFeignSpi{

	@Override
	public String hi(String name) {
		return "[Feign 熔断器] 服务已故障 ：" + name;
	}

	@Override
	public String getUser(String userId) {
		return "[Feign 熔断器] 服务已故障 ：" + userId;
	}

}