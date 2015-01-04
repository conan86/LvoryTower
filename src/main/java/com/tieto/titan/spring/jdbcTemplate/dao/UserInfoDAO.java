package com.tieto.titan.spring.jdbcTemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.util.Assert;

public class UserInfoDAO{
	private JdbcTemplate   jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate  jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void addUserInfo(final UserInfo userInfo) {
		Assert.notNull(userInfo, "userInfo is not null");  
		String INSERT_USER_INFO ="INSERT INTO.`user_info` ( `username`, `age`, `password`) VALUES (?,?,?)" ;
		
		jdbcTemplate.update(INSERT_USER_INFO,new PreparedStatementSetter(){
			@Override
			public void setValues(java.sql.PreparedStatement ps)
					throws SQLException {
				ps.setString(1, userInfo.getUsername()); 
				ps.setInt(2, userInfo.getAge());
                ps.setString(3, userInfo.getPassword()); 
			} 
		});
	}
	
	public UserInfo queryById( int id) {
		String sql = "SELECT id,username,age,password FROM user_info where id =?";
		return ((UserInfo)jdbcTemplate.queryForObject(sql, new RowMapper<UserInfo> () {
			@Override
			public UserInfo mapRow(ResultSet rs, int index) throws SQLException {
				UserInfo userInfo = new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setAge(rs.getInt("age"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setUsername(rs.getString("username"));
				return userInfo;
			}
		}, id));
	}
	
	public String queryUsernameById(int id) {
		String sql = "SELECT username FROM user_info where id =?";
		return jdbcTemplate.queryForObject(sql,new Object[] { id },String.class);
	}
	
	public int getCountOfRows() {
		String sql ="select count(id) from user_info";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	
	
	
}
