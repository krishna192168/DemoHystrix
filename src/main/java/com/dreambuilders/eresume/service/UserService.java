package com.dreambuilders.eresume.service;

import org.springframework.stereotype.Service;

import com.dreambuilders.eresume.model.User;
import com.dreambuilders.eresume.restutil.UserRestUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserService {


	@HystrixCommand(fallbackMethod = "interrupt")
	public User getUser() {
		return UserRestUtil.getUser();
	}
	public User interrupt()
	{
		User user = new User();
		user.setEmail("Service unavialble");
		user.setName("Service unavialble");
		return user;
	}
}
