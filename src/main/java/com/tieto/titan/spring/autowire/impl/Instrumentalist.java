package com.tieto.titan.spring.autowire.impl;

import javax.inject.Inject;
import javax.inject.Named;



//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tieto.titan.spring.autowire.Instrument;
import com.tieto.titan.spring.autowire.Performer;

@Component("john")
public class Instrumentalist implements Performer {

	@Value(value = "#{songSelector.selectSong()}")
	private String song;

	//@Autowired
	//@Qualifier("saxophone")
	
	@Inject
	@Named(value="saxophone")
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
	public void perform() throws Exception  {
		try {
			System.out.println("Playing " + song + " : ");
			if(instrument == null) {
				throw new NullPointerException();
			}
			instrument.play();
		}catch(Exception e) {
			throw e;
		}
		
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
