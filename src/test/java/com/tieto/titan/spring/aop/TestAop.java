package com.tieto.titan.spring.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tieto.titan.spring.autowire.Performer;

public class TestAop {
	private static AbstractApplicationContext  ctx = null;
	@Before
	public void setUp()  throws Exception{
		if(ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
		}else {
			System.out.println("ctx is not null");
			return;
		}
	}
	
	@Test
	public void testAop() {
		Performer kenny = (Performer) ctx.getBean("kenny");
		try {
				kenny.perform();
				//Instrumentalist performer =(Instrumentalist)kenny;
				//performer.setInstrument(null);
				//performer.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		if(ctx != null) {
			ctx.registerShutdownHook();
		}
	}
}
