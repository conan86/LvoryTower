package com.tieto.titan.spring.ioc.impl;

import com.tieto.titan.spring.ioc.Instrument;
import com.tieto.titan.spring.ioc.Performer;

public class Instrumentalist implements Performer {

	private String song;
	
	private Instrument instrument;
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Playing " + song + " : ");
		instrument.play();
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
}
