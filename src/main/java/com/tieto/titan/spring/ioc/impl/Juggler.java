package com.tieto.titan.spring.ioc.impl;

import com.tieto.titan.spring.ioc.Performer;

public class Juggler implements Performer {

	private int beanBags = 3;
	
	public Juggler (int number) {
		this.beanBags = number;
	}
	
	public Juggler () {
		
	}
	@Override
	public void perform() {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}
}
