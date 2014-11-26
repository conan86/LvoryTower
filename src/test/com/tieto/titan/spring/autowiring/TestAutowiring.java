package com.tieto.titan.spring.autowiring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tieto.titan.spring.ioc.Performer;
import com.tieto.titan.spring.ioc.impl.Juggler;

import junit.framework.TestCase;

public class TestAutowiring extends TestCase{
	
	private static AbstractApplicationContext  ctx = null;
	@Before
	public void setUp()  throws Exception{
		if(ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring/spring-autowire.xml");
		}else {
			System.out.println("ctx is not null");
			return;
		}
	}
	
	@Test
	public void testAutowireByName() {
		Performer keny2= (Performer) ctx.getBean("keny2");
		keny2.perform();
	}
	
	@Test
	public void testAutowireByType() {
		Performer keny3= (Performer) ctx.getBean("keny3");
		keny3.perform();
	}
	
	@Test
	public void testAutowireByConstructor() {
		Juggler duke = (Juggler) ctx.getBean("duck");
		duke.perform();
	}
	
	@Test
	public void testDefaultAutowire() {
		//Test config the default-autowire type in <beans>
		Performer keny4= (Performer) ctx.getBean("keny4");
		keny4.perform();
	}
	
	@After
	public void tearDown() {
		ctx.registerShutdownHook();
	}
	
}
