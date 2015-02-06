package com.tieto.titan.spring.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO{
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
	
	public List<UserInfo> getAllUserInfo() {
		String sql = "select id, username, password,age,photoPath from user_info";
		return jdbcTemplate.query(sql,  new RowMapper<UserInfo> () {
			@Override
			public UserInfo mapRow(ResultSet rs, int index) throws SQLException {
				UserInfo userInfo = new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setAge(rs.getInt("age"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setUsername(rs.getString("username"));
				userInfo.setPhotoPath(rs.getString("photoPath"));
				return userInfo;
			}
		});
	}

}
