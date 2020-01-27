package com.dreambuilders.eresume.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreambuilders.eresume.model.User;
import com.dreambuilders.eresume.service.UserService;

@RestController
public class UserController {
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/user")
	@ApiOperation("Get user details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = User.class),
			@ApiResponse(code = 400, message = "user details is not available", response = User.class) })
	public ResponseEntity<?> getUser()
	{
		User user = userService.getUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
