package com.tieto.titan.spring.autowire.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tieto.titan.spring.autowire.Instrument;

@Component("saxophone")
public class Saxophone implements Instrument {
	
	@Value(value="10010")
	private String number;

	@Override
	public void play() {
		System.out.println("Saxophone : #" +number);
		System.out.println("Saxophone TOOT TOOT TOOT..");
	}

}
