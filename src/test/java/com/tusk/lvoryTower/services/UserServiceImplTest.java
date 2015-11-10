package com.tusk.lvoryTower.services;

import org.junit.Assert;
import static org.mockito.Mockito.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tusk.lvoryTower.module.User;

public class UserServiceImplTest extends TestCase {

	private UserService userService;
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
	
	private void setUpGetUserCount() {
		userService = mock(UserService.class);
		when(userService.getUserCount()).thenReturn(0);
	}

	@Test
	public void testGetUserCount() {
		setUpGetUserCount();
		//userService = (UserService) ctx.getBean("userService");
		Assert.assertEquals(0, userService.getUserCount());
	}
	
	
	private void setUpGetUserById() {
		userService = mock(UserService.class);
		User user = new User();
		user.setUserId(1);
		user.setUsername("Conan");
		when(userService.getUserById(1)).thenReturn(user);
	}
	@Test
	public void testGetUserById() {
		//UserService userService= (UserService) ctx.getBean("userService");
		setUpGetUserById();
		User user = userService.getUserById(1);
		Assert.assertEquals("Conan", user.getUsername());
	}

	@After
	public void tearDown() {
		userService = null;
	}

}
