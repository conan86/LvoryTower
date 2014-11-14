package com.tieto.titan.spring.ioc.impl;

import com.tieto.titan.spring.ioc.Instrument;

public class Piano implements Instrument {
	
	private String number;
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Piano #" + number);
		System.out.println("PLINK PLINK PLINK ........"); 
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
