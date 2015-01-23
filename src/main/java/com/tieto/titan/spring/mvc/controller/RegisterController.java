package com.tieto.titan.spring.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;

@Controller
@RequestMapping("register")
public class RegisterController {
	
	@RequestMapping(method=RequestMethod.GET,params="new")
	public String listAllRegisterOptions(Map<String,Object> model) {
		model.put("userInfo", new UserInfo());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(@Validated UserInfo userInfo, @RequestParam(value="photo",required=false) MultipartFile photo,BindingResult bindingResult,Model model) {
		//System.out.println(userInfo.getUsername());
		//System.out.println(photo);
		model.addAttribute("message", "Register Successful, Please try to login.");
		return "redirect:login";
	}
	
}
