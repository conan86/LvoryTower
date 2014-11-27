package com.tieto.titan.spring.spel;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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
	
	@Test
	public void testConditionExpression() {
		Performer john = (Performer) ctx.getBean("john");
		john.perform();
	}
	
	@Test
	public void testRegularExpression() {
		SpelBean4 spelBean4 = (SpelBean4) ctx.getBean("spelBean4");
		printAllParametersValue(spelBean4);
	}

	@Test
	public void testUtil() {
		SpelBean4 spelBean4 = (SpelBean4) ctx.getBean("spelBean4");
		printAllParametersValue(spelBean4.getChosenCity());
		printAllParametersValue(spelBean4.getChosenCity2());
		printAllParametersValue(spelBean4.getChosenCity3());
		System.out.println(spelBean4.getDbUsername());
		System.out.println(spelBean4.getHomePath());
		System.out.println(spelBean4.getUserDirPath());
		System.out.println(spelBean4.getGetStringByIndex());
		System.out.println("--------------get big cities--------------");
		List<City> cities = spelBean4.getBigCities();
		for(City city : cities) {
			printAllParametersValue(city);
			//System.out.println(city.getName());
		}
		System.out.println("--------------get a  big city--------------");
		printAllParametersValue(spelBean4.getaBigCity());
		printAllParametersValue(spelBean4.getaBigCity2());

		System.out.println("-----------------get all cities name-------------------------------");
		for(String name: spelBean4.getCityNames()) {
			System.out.println(name);
		}
		
		System.out.println("-----------------get all cities and states name-------------------------------");
		for(String name: spelBean4.getCityAndStatesNames()) {
			System.out.println(name);
		}
		
		Map<?,?> citiesMap = (Map<?,?>) ctx.getBean("citiesMap");
		System.out.println(citiesMap);
		
		System.out.println("-----------------get all big cities and states name-------------------------------");
		for(String name: spelBean4.getBigCityNamesAndStates()) {
			System.out.println(name);
		}
		
		/*
		 * List<?> cities = (List<?>) ctx.getBean("cities");
		double d = Math.random()*cities.size();
		System.out.println(d);
		*/
		
		/*
		Properties dbSetting = (Properties) ctx.getBean("db_settings");
		System.out.println(dbSetting.get("user.username"));
		*/
		
		/*
		Properties systemProperties = (Properties) ctx.getBean("systemProperties");
		for(Object key: systemProperties.keySet()) {
			 System.out.print(key + " = ");
			 System.out.println(systemProperties.getProperty( key.toString()));
		}
		*/
		
		/*
		Properties systemEnvironment = (Properties) ctx.getBean("systemEnvironment");
		System.out.println(systemEnvironment);
		*/
		
	}
	
	@After
	public void tearDown() {
		ctx.registerShutdownHook();
	}
}
