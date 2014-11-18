package com.tieto.titan.spring.spel;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tieto.titan.spring.ioc.Performer;

public class TestSpel {
	private static AbstractApplicationContext ctx = null;

	private void printAllParametersValue(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			// System.out.println(f);
			f.setAccessible(true);
			String field = f.toString().substring(
					f.toString().lastIndexOf(".") + 1);
			try {
				System.out.println(obj.getClass().getSimpleName() + "." + field
						+ " = " + f.get(obj));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Before
	public void setUp() throws Exception {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring/spring-spel.xml");
		} else {
			//System.out.println("ctx is not null");
			return;
		}
	}

	@After
	public void tearDown() {
		ctx.registerShutdownHook();
	}

	

	@Test
	public void testSimpleSpel() {
		SpelBean spelBean = (SpelBean) ctx.getBean("spelBean1");
		printAllParametersValue(spelBean);
	}

	@Test
	public void testSpelInjectBean() {
		System.out.println("------------------------------------------");
		SpelBean2 spelBean2 = (SpelBean2) ctx.getBean("spelBean2");
		printAllParametersValue(spelBean2);
		System.out.println("------------------------------------------");
		Performer kenny = (Performer) ctx.getBean("kenny");
		kenny.perform();
		System.out.println("------------------------------------------");
		Performer carl = (Performer) ctx.getBean("carl");
		carl.perform();
		System.out.println("------------------------------------------");
		printAllParametersValue(kenny);
		printAllParametersValue(carl);

		System.out.println("------------------------------------------");
		Performer conan = (Performer) ctx.getBean("conan");
		conan.perform();

	}
	
	@Test
	public void testSpelCreateInstanceDirectlyAndOperator() {
		SpelBean3 spelBean3 = (SpelBean3) ctx.getBean("spelBean3");
		printAllParametersValue(spelBean3);
	}

}
