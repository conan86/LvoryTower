package com.tieto.titan.spring.jdbcTemplate;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tieto.titan.spring.jdbcTemplate.dao.UserInfo;
import com.tieto.titan.spring.jdbcTemplate.dao.UserInfoDAO;
import com.tieto.titan.spring.jdbcTemplate.dao.UserInfoDAO2;

public class TestJdbcTemplate {
	private static AbstractApplicationContext ctx = null;

	@Before
	public void setUp() throws Exception {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring/spring-jdbcTemplate.xml");
		} else {
			//System.out.println("ctx is not null");
			return;
		}
	}
	
	@Test
	public void testAddUserInfo() {
		UserInfoDAO dao = (UserInfoDAO) ctx.getBean("userInfoDAO");
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("Sun xiaonan");
		userInfo.setPassword("abcd");
		userInfo.setAge(28);
		dao.addUserInfo(userInfo);
	}
	
	@Test
	public void testAddUserInfo2() {
		UserInfoDAO2 dao = (UserInfoDAO2) ctx.getBean("userInfoDAO2");
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("Sun Xiaonan");
		userInfo.setPassword("abcd");
		userInfo.setAge(28);
		dao.addUserInfo(userInfo);
	}
	
	@Test
	public void testQueryForObject1() {
		UserInfoDAO dao = (UserInfoDAO) ctx.getBean("userInfoDAO");
		UserInfo userInfo = dao.queryById(1);
		System.out.println(userInfo.getUsername());
		Assert.assertEquals("conan", userInfo.getUsername());
	}

	@Test
	public void testQueryUsernameById() {
		UserInfoDAO dao = (UserInfoDAO) ctx.getBean("userInfoDAO");
		String username = dao.queryUsernameById(2);
		System.out.println(username);
	}
	
	@Test
	public void testGetCountOfRows() {
		UserInfoDAO dao = (UserInfoDAO) ctx.getBean("userInfoDAO");
		System.out.println(dao.getCountOfRows());
	}
	
	@After
	public void tearDown() {
		ctx.registerShutdownHook();
	}
}
