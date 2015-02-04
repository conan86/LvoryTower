package com.tieto.titan.spring.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;
import com.tieto.titan.spring.mvc.dao.LoginDAO;

@Service("loginService")
public class LoginService {
	
	@Resource(name="loginDAO")
	private LoginDAO loginDAO ;
	
	public boolean  verifyUser(String username, String password) {
		int i =  loginDAO.verifyUser(username, password);
		if(i >0) {
			return true;
		}
		return false;
	}
	
	public List<UserInfo> getAllUserInfo() {
		return loginDAO.getAllUserInfo();
	}
}
