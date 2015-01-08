package com.tieto.titan.spring.jdbcTemplate.bean;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;  

/**
 * 
 * @author sunnoxia
 * @category RowMapper
 * 
 *mapping order:  id,username,password,age
 */
public class UserInfoRowMapper implements  RowMapper<UserInfo> {

	/**
	 * args
	 * id,username,password,age
	 */
	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt(1);
		String username = rs.getString(2);
		String password = rs.getString(3);
		int age = rs.getInt(4);
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(age);
		userInfo.setId(id);
		userInfo.setPassword(password);
		userInfo.setUsername(username);
		return  userInfo;
	}
}
