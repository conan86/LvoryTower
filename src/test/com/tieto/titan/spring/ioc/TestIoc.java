package com.tieto.titan.spring.ioc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tieto.titan.spring.ioc.impl.AuditoriumImpl;
import com.tieto.titan.spring.ioc.impl.Instrumentalist;
import com.tieto.titan.spring.ioc.impl.Saxophone;
import com.tieto.titan.spring.ioc.impl.Stage;
import com.tieto.titan.spring.ioc.impl.Ticket;

import junit.framework.TestCase;

public class TestIoc extends TestCase {
	private static AbstractApplicationContext  ctx = null;
	
	@Before
	public void setUp()  throws Exception{
		if(ctx == null) {
			ctx = new ClassPathXmlApplicationContext("spring/spring-ioc.xml");
		}else {
			System.out.println("ctx is not null");
			return;
		}
	}

	@Test
	public void testConstructorInject () {
		Performer duke = (Performer) ctx.getBean("duke");
		duke.perform();
	}
	
	@Test
	public void testConstructorInjectOtherBean () {
		Performer John = (Performer) ctx.getBean("poeticDuke");
		John.perform();
	}
	
	@Test
	public void testFactoryMethod() {
		Stage stage = (Stage) ctx.getBean("theStage");
		System.out.println(stage);
		System.out.println("--------------------------------------");
		Stage stage2 = (Stage) ctx.getBean("theStage");
		System.out.println(stage2);
		//stage == stage2
	}
	
	@Test
	public void testScope() {
		System.out.println("--------------------------------------");
		Ticket t1 = (Ticket) ctx.getBean("ticket");
		System.out.println(t1);
		
		System.out.println("--------------------------------------");
		Ticket t2 = (Ticket) ctx.getBean("ticket");
		System.out.println(t2);
		
		System.out.println("--------------------------------------");
		Ticket t3 = (Ticket) ctx.getBean("ticket2");
		System.out.println(t3);
		
		System.out.println("--------------------------------------");
		Ticket t4 = (Ticket) ctx.getBean("ticket2");
		System.out.println(t4);
	}
	
	@Test
	public void testInitAndDestoryMethod() {
		Auditorium audi = (Auditorium) ctx.getBean("auditorium");
		System.out.println(audi);
		if(audi instanceof AuditoriumImpl) {
			AuditoriumImpl auditoriumImpl = (AuditoriumImpl)audi;
			auditoriumImpl.action();
		}
	}
	
	@Test
	public void testDefaultInitAndDestoryMethod() {
		System.out.println("--------------------------------------");
		Auditorium audi2 = (Auditorium) ctx.getBean("auditorium2");
		System.out.println(audi2);
		if(audi2 instanceof AuditoriumImpl) {
			AuditoriumImpl auditoriumImpl = (AuditoriumImpl)audi2;
			auditoriumImpl.action();
		}
	}
	
	@Test
	public void testInjectByProperty() {
		Performer kenny = (Performer) ctx.getBean("kenny");
		kenny.perform();
	}
	
	@Test
	public void testInjectInnerBean() {
		System.out.println("--------------------------------------");
		Performer kenny2 = (Performer) ctx.getBean("kenny2");
		kenny2.perform();
		
		System.out.println("--------------------------------------");
		// Inject a inner bean by constructor-arg
		Performer John2 = (Performer) ctx.getBean("poeticDuke2");
		John2.perform();
	}
	
	@Test
	public void testInjectByNamespaceP() {
		Instrumentalist kenny3 = (Instrumentalist) ctx.getBean("kenny3");
		Instrument instrument = kenny3.getInstrument();
		if(instrument instanceof Saxophone) {
			System.out.println(((Saxophone)instrument).getNumber());
		}
		kenny3.perform();
	}
	
	@Test
	public void testInjectUntils() {
		System.out.println("--------------------------------------");
		Performer hank = (Performer) ctx.getBean("band");
		hank.perform();
		
		System.out.println("--------------------------------------");
		Performer hank2 = (Performer) ctx.getBean("hank");
		hank2.perform();
	}
	
	@After
	public void tearDown() {
		ctx.registerShutdownHook();
	}
}
