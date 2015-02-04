package com.tieto.titan.spring.mvc.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.tieto.titan.spring.mvc.service.LoginService;

@Controller
public class LoginController{
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String login( Map<String,Object> model,String message) {
		model.put("message", message);
		return "login";
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, 
	        //@RequestParam(value="username", required=true) String username, 
			String username, 
	        //@RequestParam(value="password", required=true) String password,
			String password,
	        Map<String,Object> model) {
		if(loginService.verifyUser(username, password)) {
			model.put("message", "Welcome");
			model.put("username", username);
			model.put("userList", loginService.getAllUserInfo());
			return "home";
		} else {
			return "redirect:hello.do";
		}
	}
}
