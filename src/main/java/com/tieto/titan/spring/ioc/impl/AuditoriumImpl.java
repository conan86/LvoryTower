package com.tieto.titan.spring.ioc.impl;

import com.tieto.titan.spring.ioc.Auditorium;

public class AuditoriumImpl implements Auditorium {

	@Override
	public void turnOnLights() {
		// TODO Auto-generated method stub
		 System.out.println("turn on lights");
	}
	
	public void action() {
		System.out.println("action!!!");
	}

	@Override
	public void turnOffLights() {
		// TODO Auto-generated method stub
		System.out.println("turn off lights");
	}

}
