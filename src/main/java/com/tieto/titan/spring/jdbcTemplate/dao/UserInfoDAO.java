package com.tieto.titan.spring.jdbcTemplate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;
import com.tieto.titan.spring.jdbcTemplate.bean.UserInfoRowMapper;

public class UserInfoDAO{
	private JdbcTemplate   jdbcTemplate;
	private PlatformTransactionManager transactionManager;
	
	public void setJdbcTemplate(JdbcTemplate  jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	
	public void addUserInfo(final UserInfo userInfo) {
		Assert.notNull(userInfo, "userInfo is not null");  
		TransactionDefinition def = new DefaultTransactionDefinition();
	     TransactionStatus status = transactionManager.getTransaction(def);
		try{
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
			transactionManager.commit(status);
		}catch(Exception e) {
			System.out.println("Error in creating record, rolling back");
	         transactionManager.rollback(status);
		}
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
	
	public UserInfo queryUserInfoById(int id) {
		String sql = "SELECT id,username,password,age FROM user_info where id =?";
		return (UserInfo) jdbcTemplate.queryForObject(sql, new Object[] {id},  new UserInfoRowMapper());
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
