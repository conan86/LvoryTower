package com.tieto.titan.spring.autowire.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tieto.titan.spring.autowire.Instrument;

@Component("instrument")
public class Piano implements Instrument {
	
	@Value(value="10086")
	private String number;
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Piano #" + number);
		System.out.println("Piano PLINK PLINK PLINK ........"); 
	}

}
