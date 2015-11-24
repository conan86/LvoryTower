package com.tusk.lvoryTower.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tusk.lvoryTower.module.User;
import com.tusk.lvoryTower.services.UserService;

@RestController
public class TestController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
	public User getUserInfo(@RequestParam(value = "userId") String userId) {
		long id = Long.parseLong(userId);
		User user = userService.getUserById(id);
		return user;
	}
}
