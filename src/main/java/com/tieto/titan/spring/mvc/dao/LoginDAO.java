package com.tieto.titan.spring.mvc.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAO {
private JdbcTemplate   jdbcTemplate;
	
	@Inject
	@Named(value="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate  jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int verifyUser(String username,String password) {
		String sql = "select count(*) from user_info where username=? and password=?";
		return jdbcTemplate.queryForObject(sql,new Object[] { username,password},Integer.class);
	}

}
