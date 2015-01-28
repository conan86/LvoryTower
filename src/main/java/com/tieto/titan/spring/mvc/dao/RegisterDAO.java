package com.tieto.titan.spring.mvc.dao;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.tieto.titan.spring.jdbcTemplate.bean.UserInfo;

@Repository("registerDAO")
public class RegisterDAO {
	
	private JdbcTemplate   jdbcTemplate;
	
	@Inject
	@Named(value="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate  jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void SaveUser(final UserInfo userInfo) {
		Assert.notNull(userInfo, "userInfo is not null");  
		String INSERT_USER_INFO ="INSERT INTO `user_info` ( `username`, `age`, `password`,`photoPath`) VALUES (?,?,?,?)" ;
		jdbcTemplate.update(INSERT_USER_INFO,new PreparedStatementSetter(){
			@Override
			public void setValues(java.sql.PreparedStatement ps)
					throws SQLException {
				ps.setString(1, userInfo.getUsername()); 
				ps.setInt(2, userInfo.getAge());
                ps.setString(3, userInfo.getPassword()); 
                ps.setString(4, userInfo.getPhotoPath());
			} 
		});
	}
}
