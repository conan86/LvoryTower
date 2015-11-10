package com.tusk.lvoryTower.dao;

import com.tusk.lvoryTower.module.User;

public interface UserDAO {
	public int countUser();
	public User getUserById(int userId);
}