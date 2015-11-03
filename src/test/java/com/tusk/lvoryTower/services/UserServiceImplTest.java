package com.tusk.lvoryTower.services;

import org.junit.Assert;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest extends TestCase {

	private static ApplicationContext  ctx = null;

	@Before
	public void setUp() throws Exception {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring.xml");
		} else {
			System.out.println("ctx is not null");
			return;
		}
	}

	@Test
	public void testGetUserCount() {
		UserService userService= (UserService) ctx.getBean("userService");
		Assert.assertEquals(0, userService.getUserCount());
	}

	@After
	public void tearDown() {
		
	}

}
