package com.tieto.titan.spring.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;
import com.tieto.titan.spring.mvc.dao.AbstractDAO;
import com.tieto.titan.spring.mvc.dao.LoginDAO;

@Service("loginService")
public class LoginService extends AbstractService {
	
	
	private AbstractDAO dao ;
	@Resource(name="loginDAO")
	@Override
	public void setDAO(AbstractDAO dao) {
		this.dao = dao;
	}
	
	public boolean  verifyUser(String username, String password) {
		int i =  ((LoginDAO) dao).verifyUser(username, password);
		if(i >0) {
			return true;
		}
		return false;
	}
	
	public List<UserInfo> getAllUserInfo() {
		return ((LoginDAO) dao).getAllUserInfo();
	}
	
}
