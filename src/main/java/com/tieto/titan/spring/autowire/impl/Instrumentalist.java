package com.tieto.titan.spring.autowire.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tieto.titan.spring.autowire.Instrument;
import com.tieto.titan.spring.autowire.Performer;

@Component("john")
public class Instrumentalist implements Performer {

	@Value(value = "#{songSelector.selectSong()}")
	private String song;

	@Autowired
	@Qualifier("saxophone")
	private Instrument instrument;

	public Instrumentalist() {
	}

	public Instrumentalist(Instrument instrument) {
		this.instrument = instrument;
	}

	public Instrumentalist(String song, Instrument instrument) {
		this.song = song;
		this.instrument = instrument;
	}

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
