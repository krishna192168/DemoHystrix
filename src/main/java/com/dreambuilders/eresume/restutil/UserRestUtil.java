package com.dreambuilders.eresume.restutil;

import org.springframework.web.client.RestTemplate;

import com.dreambuilders.eresume.model.User;

public class UserRestUtil {
	private UserRestUtil() {}
	public static User getUser()
	{
		final String uri = "https://api.myjson.com/bins/n9z3e";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, User.class);
	}
	//Here check whether the response is available or not
	public static void main(String args[])
	{
		System.out.println(UserRestUtil.getUser());
	}
}
