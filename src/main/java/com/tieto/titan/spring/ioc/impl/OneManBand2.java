package com.tieto.titan.spring.ioc.impl;

import java.util.Map;

import com.tieto.titan.spring.ioc.Instrument;
import com.tieto.titan.spring.ioc.Performer;

public class OneManBand2 implements Performer {
	
	private Map<String,Instrument> instruments;

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		 for(String key : instruments.keySet()) {
			 System.out.println("key : " + key);
			 Instrument instrument = instruments.get(key);
			 instrument.play();
		 }
	}

	public Map<String,Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Map<String,Instrument> instruments) {
		this.instruments = instruments;
	}

}
