package com.dreambuilders.eresume.controller;

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
	public ResponseEntity<?> getUser()
	{
		User user = userService.getUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
