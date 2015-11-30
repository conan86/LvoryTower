package com.tusk.lvoryTower.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tusk.lvoryTower.module.User;
import com.tusk.lvoryTower.services.UserService;

@RestController
public class TestController {

	@Resource
	private UserService userService;

	@RequestMapping("getUserInfo")
	public User getUserInfo(@RequestParam(value = "userId") String userId) throws JsonProcessingException {
		long id = Long.parseLong(userId);
		User user = userService.getUserById(id);
		return user;
	}
	
	@RequestMapping("getUserInfo2")
	public User getUserInfo2(@RequestHeader("uuid") String uuid,@RequestBody String body) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		user = mapper.readValue(body,  User.class);
		user = userService.getUserById(user.getUserId());
		user.setIdCardPhotoPath(uuid);
        return user;
	}

}
