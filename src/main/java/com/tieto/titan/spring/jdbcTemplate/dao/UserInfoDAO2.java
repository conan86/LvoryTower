package com.tieto.titan.spring.jdbcTemplate.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;

public class UserInfoDAO2 extends JdbcDaoSupport {
	
	public void addUserInfo(UserInfo userInfo) {
		String INSERT_USER_INFO ="INSERT INTO.`user_info` ( `username`, `age`, `password`) VALUES (?,?,?);" ;
		this.getJdbcTemplate().update(INSERT_USER_INFO,userInfo.getUsername(), userInfo.getAge(),userInfo.getPassword());
	}
	
	
	
}
