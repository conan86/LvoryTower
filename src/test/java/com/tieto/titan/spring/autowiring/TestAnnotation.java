package com.tieto.titan.spring.autowiring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tieto.titan.spring.autowire.Performer;

import junit.framework.TestCase;

public class TestAnnotation extends TestCase{
	private static AbstractApplicationContext  ctx = null;
	@Before
	public void setUp()  throws Exception{
		if(ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring/spring-annotation.xml");
		}else {
			System.out.println("ctx is not null");
			return;
		}
	}
	
	@Test
	public void testAnnotation1() {
		Performer performer = (Performer) ctx.getBean("john");
		performer.perform();
	}
	@After
	public void tearDown() {
		ctx.registerShutdownHook();
	}
}
