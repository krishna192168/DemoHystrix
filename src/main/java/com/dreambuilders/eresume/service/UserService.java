package com.dreambuilders.eresume.service;

import org.springframework.stereotype.Service;

import com.dreambuilders.eresume.model.User;
import com.dreambuilders.eresume.restutil.UserRestUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserService {

	@HystrixCommand(fallbackMethod = "interrupt", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="1000")
	})
	public User getUser()
	{
		return UserRestUtil.getUser();
	}
	
	public String interrupt()
	{
		return "Service unavialble";
	}
	
}
