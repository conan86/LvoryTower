package com.tusk.lvoryTower.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.tusk.lvoryTower.dao.UserDAO;
import com.tusk.lvoryTower.module.User;
import com.tusk.lvoryTower.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	protected UserDAO dao;

	@Inject
	@Named("userDao")
	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	@Override
	public int getUserCount() {
		return dao.countUser();
	}

	@Override
	public User getUserById(long userId) {
		User user = null;
		user = dao.getUserById(userId);
		return user;
	}

}
