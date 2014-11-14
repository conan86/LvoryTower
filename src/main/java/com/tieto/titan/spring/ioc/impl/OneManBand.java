package com.tieto.titan.spring.ioc.impl;

import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import com.tieto.titan.spring.ioc.Instrument;
import com.tieto.titan.spring.ioc.Performer;

public class OneManBand implements Performer{
	
	private Collection<Instrument> instruments;

	private Instrument[] instrumentsArr;
	
	private Set<Instrument>  instrumentsSet;
	
	private Properties instrumentsPros;
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		for(Instrument instrument: instruments) {
			instrument.play();
		}
		System.out.println("---");
		for(Instrument instrument: instrumentsArr) {
			instrument.play();
		}
		System.out.println("---");
		for(Instrument instrument: instrumentsSet) {
			instrument.play();
		}
		
		System.out.println("---");
		for(Object key: getInstrumentsPros().keySet() ) {
			System.out.println(key +"  :  "  + instrumentsPros.getProperty((String) key));
		}
	}

	public Collection<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Instrument[] getInstrumentsArr() {
		return instrumentsArr;
	}

	public void setInstrumentsArr(Instrument[] instrumentsArr) {
		this.instrumentsArr = instrumentsArr;
	}

	public Set<Instrument> getInstrumentsSet() {
		return instrumentsSet;
	}

	public void setInstrumentsSet(Set<Instrument> instrumentsSet) {
		this.instrumentsSet = instrumentsSet;
	}

	public Properties getInstrumentsPros() {
		return instrumentsPros;
	}

	public void setInstrumentsPros(Properties instrumentsPros) {
		this.instrumentsPros = instrumentsPros;
	}
	
}
