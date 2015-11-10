package com.tusk.lvoryTower.services;

import com.tusk.lvoryTower.module.User;

public interface UserService {
	public int getUserCount();
	public User getUserById(int userId);
}